package com.rideshare.rideservice.service;

import com.rideshare.rideservice.dto.RideRequest;
import com.rideshare.rideservice.dto.RideResponse;
import com.rideshare.rideservice.event.RideRequestedEvent;
import com.rideshare.rideservice.model.Ride;
import com.rideshare.rideservice.model.RideStatus;
import com.rideshare.rideservice.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RideService {

    private  final RideRepository rideRepository;
    private final KafkaTemplate<String, RideRequestedEvent> kafkaTemplate;

    private static final String RIDE_REQUESTED_TOPIC = "ride.requested";

    /*
    * create ride in DB with REQUESTED STATUS
    */
    public RideResponse requestService(RideRequest rideRequest) {
        log.info("New roide request from rider: {}", rideRequest.getRiderId());

        // Step 1: save ride to database
        Ride ride = new Ride();
        ride.setRiderId(rideRequest.getRiderId());
        ride.setPickupLatitude(rideRequest.getPickupLatitude());
        ride.setPickupLongitude(rideRequest.getPickupLongitude());
        ride.setDropLatitude(rideRequest.getDropLatitude());
        ride.setDropLongitude(rideRequest.getDropLongitude());
        ride.setDropAddress(rideRequest.getDropAddress());
        ride.setStatus(RideStatus.REQUESTED);
        ride.setEstimatedFare(calculateEstimateFare(rideRequest));

        Ride savedride = rideRepository.save(ride);

        // Step 2: Publish event to kafka.
        // Matching service will consume this and find nearest driver.
        RideRequestedEvent event = new RideRequestedEvent(
                savedride.getId(),
                savedride.getRiderId(),
                savedride.getPickupLatitude(),
                savedride.getPickupLongitude(),
                savedride.getPickupAddress(),
                savedride.getDropLatitude(),
                savedride.getDropLongitude(),
                savedride.getDropAddress()
        );

        kafkaTemplate.send(RIDE_REQUESTED_TOPIC, savedride.getId(), event);

        log.info("RideRequestedEvent published to kafka for ride: {}", savedride.getId());

        // Update status to Matching
        savedride.setStatus(RideStatus.MATCHING);
        rideRepository.save(savedride);

        return mapToResponse(savedride);
    }

    private double calculateEstimateFare(RideRequest rideRequest) {
        // Simplified Haversine distance calculation.
        double lat1 = Math.toRadians(rideRequest.getPickupLatitude());
        double lat2 = Math.toRadians(rideRequest.getDropLatitude());

        double long1 = Math.toRadians(rideRequest.getPickupLongitude());
        double long2 = Math.toRadians(rideRequest.getDropLongitude());

        double dLat = lat2 - lat1;
        double dLon = long2 - long1;

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double distanceInKm = 6371 * c; // Earth radius in km

        // Base fare: 50Rs + 12Rs/km
        double fare = 50 + (distanceInKm * 12);
        return Math.round(fare * 100.0) / 100.0;
    }

    private void updateRideWithDriver(String rideId, String driverId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        ride.setDriverId(driverId);
        ride.setStatus(RideStatus.ACCEPTED);
        rideRepository.save(ride);
    }

    public RideResponse startRide(String rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        if(ride.getStatus() != RideStatus.ACCEPTED) {
            throw new RuntimeException("Ride cannot be started. Current status: "+ride.getStatus());
        }

        ride.setStatus(RideStatus.RIDE_STARTED);
        ride.setStartedAt(LocalDateTime.now());
        rideRepository.save(ride);

        return mapToResponse(ride);
    }

    public RideResponse completeRide(String rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        if(ride.getStatus() != RideStatus.RIDE_STARTED) {
            throw new RuntimeException("Ride can't be completed. Current Status "+ride.getStatus());
        }

        ride.setStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());
        ride.setActualFare(ride.getEstimatedFare());
        rideRepository.save(ride);

        return mapToResponse(ride);
    }

    public RideResponse cancelRide(String rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        ride.setStatus(RideStatus.CANCELLED);
        rideRepository.save(ride);

        return mapToResponse(ride);
    }

    private RideResponse mapToResponse(Ride savedride) {
        RideResponse response = new RideResponse();
        response.setId(savedride.getId());
        response.setRiderId(savedride.getRiderId());
        response.setDriverId(savedride.getDriverId());
        response.setPickupLatitude(savedride.getPickupLatitude());
        response.setPickupLongitude(savedride.getPickupLongitude());
        response.setPickupAddress(savedride.getPickupAddress());
        response.setDropLatitude(savedride.getDropLatitude());
        response.setDropLongitude(savedride.getDropLongitude());
        response.setDropAddress(savedride.getDropAddress());
        response.setStatus(savedride.getStatus());
        response.setEstimatedFare(savedride.getEstimatedFare());
        response.setActualFare(savedride.getActualFare());
        response.setCreatedAt(savedride.getCreatedAt());
        response.setUpdatedAt(savedride.getUpdatedAt());
        response.setStartedAt(savedride.getStartedAt());
        response.setCompletedAt(savedride.getCompletedAt());
        return response;
    }

    public RideResponse getRiderById(String rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        return mapToResponse(ride);
    }

    public List<RideResponse> getRidesByRider(String riderId) {
        return rideRepository.findByRiderIdOrderByCreatedAtDesc(riderId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}

package com.rideshare.matching_service.service;

import com.rideshare.matching_service.client.LocationServiceClient;
import com.rideshare.matching_service.dto.NearByDriverResponse;
import com.rideshare.matching_service.event.RideMatchedEvent;
import com.rideshare.matching_service.event.RideRequestedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchingService {

    private final LocationServiceClient locationServiceClient;
    private final KafkaTemplate<String, RideMatchedEvent> kafkaTemplate;

    private static final String RIDE_MATCHED_TOPIC = "ride.matched";
    private static final double DEFAULT_SEARCH_RADIUS_KM = 5.0;

    /**
     * Main matching algorithm
     * Called when RideRequestedEvent is consumed from Kafka
     * @param event
     *
     * STEPS:
     * 1. Ask Location Service for nearby drivers
     * 2. Score each driver and pick the best one.
     */
    public void matchDriverForRide(RideRequestedEvent event) {
        List<NearByDriverResponse> nearByDrivers = locationServiceClient.getNearByDrivers(
                event.getPickupLatitude(),
                event.getPickupLongitude(),
                DEFAULT_SEARCH_RADIUS_KM
        );

        if(nearByDrivers.isEmpty()) {
            log.warn("No Drivers found near ride: {}");
            return;
        }

        // STEP 2: Score each driver and pick the best one.
        Optional<NearByDriverResponse> bestDriver = findBestDriver(nearByDrivers);

        if(bestDriver.isEmpty()) {
            log.warn("Couldn't find suitable driver for ride.");
            return;
        }

        NearByDriverResponse assignedDriver = bestDriver.get();

        // STEP 3: Publish RideMatched event to kafka
        RideMatchedEvent rideMatchedEvent = new RideMatchedEvent(
                event.getRideId(),
                event.getRiderId(),
                assignedDriver.getDriverId(),
                assignedDriver.getLatitude(),
                assignedDriver.getDistanceInKm(),
                assignedDriver.getLongitude()
        );

        kafkaTemplate.send(RIDE_MATCHED_TOPIC, event.getRideId(), rideMatchedEvent);
        log.info("RideMatchedEvent published");
    }

    /**
     * Driver Scoring algorithms
     *
     * Distance: 70%
     * Rating: 30%
     *
     * Score = (1 / distance) * distanceWeight + ratingWeight
     *
     * @param driverResponses
     * @return
     */
    private Optional<NearByDriverResponse> findBestDriver(
            List<NearByDriverResponse> driverResponses
    ) {
        double distanceWeight = 0.7;
        double ratingWeight = 0.3;

        return driverResponses.stream()
                .max(Comparator.comparingDouble(driver -> {
                    // Distance score: higher score
                    // Add 0.1 to avoid division by 0.
                    double distanceScore = 1.0 / (driver.getDistanceInKm() + 0.1);

                    // Simulated rating b/w 4.0 and 5.0
                    // In production we need to fetch from driver service.
                    double simulatedRating = 4.0 + Math.random();

                    // Final weighted score
                    return (distanceScore * distanceWeight) + (simulatedRating * ratingWeight);
                }));
    }
}

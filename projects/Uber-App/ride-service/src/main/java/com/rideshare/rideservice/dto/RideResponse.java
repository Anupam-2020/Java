package com.rideshare.rideservice.dto;

import com.rideshare.rideservice.model.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideResponse {

    private String id;

    private String riderId;

    // who accepted the ride(null until matched.
    private String driverId;

    private double pickupLatitude;

    private double pickupLongitude;

    private String pickupAddress;

    private double dropLatitude;

    private double dropLongitude;

    private String dropAddress;

    // Ride status - tracks the lifecycle.
    private RideStatus status;

    // Fare Details.
    private double estimatedFare;
    private double actualFare;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // trip - started and completed at.
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
}

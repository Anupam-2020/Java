package com.rideshare.rideservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String riderId;

    // who accepted the ride(null until matched.
    private String driverId;

//    @Column(nullable = false)
    private double pickupLatitude;

//    @Column(nullable = false)
    private double pickupLongitude;

    @Column(nullable = false)
    private String pickUpAddress;

//    @Column(nullable = false)
    private double dropLatitude;

//    @Column(nullable = false)
    private double dropLongitude;

    @Column(nullable = false)
    private String dropAddress;

    // Ride status - tracks the lifecycle.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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

package com.rideshare.rideservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequest {

    @NotBlank(message = "Rider Id is required")
    private String riderId;

    @NotBlank(message = "PickUp latitude is required")
    private double pickupLatitude;

    @NotBlank(message = "PickUp longitude is required")
    private double pickupLongitude;

    @NotBlank(message = "PickUp address is required")
    private String pickUpAddress;

    @NotBlank(message = "Drop latitude is required")
    private double dropLatitude;


    @NotBlank(message = "Drop longitude is required")
    private double dropLongitude;


    @NotBlank(message = "Drop address is required")
    private String dropAddress;
}

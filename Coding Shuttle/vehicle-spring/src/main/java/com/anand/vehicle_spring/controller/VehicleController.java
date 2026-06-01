package com.anand.vehicle_spring.controller;

import com.anand.vehicle_spring.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    private VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/start")
    public String start() {
        return vehicleService.startVehicle();
    }

    @GetMapping("/stop")
    public String stop() {
        return vehicleService.stopVehicle();
    }

    @GetMapping("/engine")
    public String getEngine() {
        return vehicleService.getVehicleName();
    }
}

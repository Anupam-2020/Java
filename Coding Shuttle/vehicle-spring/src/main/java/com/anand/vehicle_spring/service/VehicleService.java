package com.anand.vehicle_spring.service;

import com.anand.vehicle_spring.components.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public final Engine engine;

    @Value("${vehicle.name}")
    private String vehicleName;

    VehicleService(@Qualifier("petEng") Engine engine) {
        this.engine = engine;
    }

    public String startVehicle() {
        return vehicleName+" -> "+engine.start();
    }

    public String stopVehicle() {
        return vehicleName+" -> "+engine.stop();
    }

    public String getVehicleName() {
        return vehicleName+" -> "+engine.getEngineType();
    }
}

package com.anand.vehicle_spring.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("dieselEng")

public class DieselEngine implements Engine {

    DieselEngine() {
        System.out.println("Diesel constructor");
    }
    @Override
    public String start() {
        return "Diesel Engine starts";
    }

    @Override
    public String stop() {
        return "Diesel Engine stops";
    }

    @Override
    public String getEngineType() {
        return "Diesel Engine";
    }
}

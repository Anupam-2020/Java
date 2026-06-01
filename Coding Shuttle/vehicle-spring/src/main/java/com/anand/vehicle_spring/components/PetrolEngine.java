package com.anand.vehicle_spring.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("petEng")
@Scope("prototype")
public class PetrolEngine implements Engine {
    PetrolEngine() {
        System.out.println("Petrol constructor");
    }

    @Override
    public String start() {
        return "Petrol Engine starts";
    }

    @Override
    public String stop() {
        return "Petrol engine stops";
    }

    @Override
    public String getEngineType() {
        return "Petrol engine";
    }
}

package org.example;

public class Car {
    Engine engine;

    Car() {
        System.out.println("Car cons....");
    }

    public void setEngine(Engine engine) {
        System.out.println("Car setter method...");
        this.engine = engine;
    }

    public void drive() {
        int start = engine.start();

        if(start > 1) {
            System.out.println("Car started with good engine...");
        } else System.out.println("Engine not start...");
    }
}

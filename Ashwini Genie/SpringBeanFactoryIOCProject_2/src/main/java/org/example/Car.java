package org.example;

public class Car {

    public Car(Engine engine) {
        System.out.println("Car constructor loaded with one arg.");
        this.engine = engine;
    }

    Car() {
        System.out.println("Car constructor loaded.");
    }
    public void setEngine(Engine engine) {
        System.out.println("Car setter method");
        this.engine = engine;
    }

    Engine engine;

    public void drive() {
        int res = engine.start();
        if(res >= 1) System.out.println("Car Engine started.");
    }
}

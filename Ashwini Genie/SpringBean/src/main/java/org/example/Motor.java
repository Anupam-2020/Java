package org.example;

public class Motor {
    Motor() {
        System.out.println("Motor constructor...");
    }

    public void start() {
        System.out.println("motor starts...");
    }

    public void doWork() {
        System.out.println("Motor pulling water...");
    }

    public void stop() {
        System.out.println("motor stops!");
    }
}

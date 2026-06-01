package org.example;

public class DieselEngine implements Engine {

    DieselEngine() {
        System.out.println("Diesel engine starts...");
    }
    @Override
    public int start() {
        System.out.println("Diesel Engine starts");
        return 0;
    }
}

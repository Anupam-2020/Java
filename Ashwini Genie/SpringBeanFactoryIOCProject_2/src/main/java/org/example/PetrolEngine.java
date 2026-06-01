package org.example;

public class PetrolEngine implements Engine {

    PetrolEngine() {
        System.out.println("Petrol engine running.");
    }

    @Override
    public int start() {
        System.out.println("Petrol Engine starts...");
        return 1;
    }
}

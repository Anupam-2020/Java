package inheritance.example2;

import inheritance.example2.Vehicle;

public class Car extends Vehicle {

    @Override
    public void drive() {
        System.out.println("Car driving...");
    }
}

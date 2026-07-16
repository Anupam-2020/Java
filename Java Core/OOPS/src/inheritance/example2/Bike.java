package inheritance.example2;

import inheritance.example2.Vehicle;

public class Bike extends Vehicle  {

    @Override
    public void drive() {
        System.out.println("Bike Driving");
    }
}

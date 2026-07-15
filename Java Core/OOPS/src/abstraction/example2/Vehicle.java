package abstraction.example2;

public abstract class Vehicle {
    abstract void drive();

    public Vehicle(String registrationNumber) {
        System.out.println("Vehicle constructor executed."+ registrationNumber);
    }
}

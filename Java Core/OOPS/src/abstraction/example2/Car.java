package abstraction.example2;

// Final class can't be extended.
// Final methods can't be overridden.
// Abstract classes can't be instantiated.
public class Car extends Vehicle {

    public Car(String registrationNumber) {
        super(registrationNumber);
        System.out.println("Car constructor called...");
    }

    @Override
    public void drive() {
        System.out.println("Car is driven...");
    }

    public static void justExample() { // static methods can't be overridden.
        System.out.println("This is a demo function/method");
    }
}

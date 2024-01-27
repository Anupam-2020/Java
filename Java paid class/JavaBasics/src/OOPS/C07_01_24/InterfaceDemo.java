package OOPS.C07_01_24;

// One of the principle of OOPS is not to make changes in existing code.
// On using Interface we can add new features to our application without changing the existing code.
// Interfaces have 100% abstraction.

interface VehicleInterface {
    int a = 0; // public, static, final( by-default )
    void speed(); // public, abstract (by-default)
}

class Bus implements VehicleInterface {
    @Override
    public void speed() {
        System.out.println(a + 60);
    }
}

class Truck implements VehicleInterface {
    @Override
    public void speed() {
        System.out.println(a + 40);
    }
}

class Car implements VehicleInterface {
    @Override
    public void speed() {
        System.out.println(a + 120);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        VehicleInterface bus = new Bus();
        VehicleInterface truck = new Truck();
        VehicleInterface car = new Car();
        bus.speed();
        truck.speed();
        car.speed();
    }
}

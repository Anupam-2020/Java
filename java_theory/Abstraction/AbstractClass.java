package Abstraction;
abstract class Car {
    public abstract void drive();
    public abstract void fly();

    public void playMusic() {
        System.out.println("Play Music");
    }
}

abstract class WagonR extends Car {

    public void drive() {
        System.out.println("WagonR driving");
    }
}

class FlyingWagonR extends WagonR {

    public void fly() {
        System.out.println("WagonR flying");
    }

    // public void drive() {
    //     System.out.println("WagonR driving and flying");
    // }
    
}

public class AbstractClass {
    public static void main(String[] args) {
        // Car obj1 = new Car(); // We can't create object of abstract class.

        Car obj2 = new FlyingWagonR();
        obj2.drive();

        Car obj1 = new FlyingWagonR();
        obj1.drive();
    }
}

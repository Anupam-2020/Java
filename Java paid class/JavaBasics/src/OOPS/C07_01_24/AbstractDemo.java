package OOPS.C07_01_24;

abstract class Vehicle { // abstract class also has constructor
    public int a;
    public abstract void engine();

    Vehicle(int a) {
        this.a = a;
        System.out.println(this.a);
    }
}

public class AbstractDemo extends Vehicle {
    AbstractDemo(int a) {
        super(a);
    }

    @Override
    public void engine() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        AbstractDemo obj = new AbstractDemo(12);
        obj.engine();
    }
}

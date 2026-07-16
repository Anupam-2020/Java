package inheritance.example2;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.drive();

        System.out.println(engine instanceof Engine); // true
        System.out.println(engine instanceof Vehicle); // true
        System.out.println(engine instanceof Car); // true

        Vehicle vehicle = new Car(); // Upcasting -> automatic. The reference is parent.
        Car car = (Car) new Vehicle(); // Downcasting -> explicit cast -> The reference is child, parent object downcasted to child.
    }
}

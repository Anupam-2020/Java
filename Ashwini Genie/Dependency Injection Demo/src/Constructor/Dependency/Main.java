package Constructor.Dependency;

public class Main {
    public static void main(String[] args) {
        Engine eng = new Engine();
        Car car = new Car(eng);
        car.drive();
    }
}
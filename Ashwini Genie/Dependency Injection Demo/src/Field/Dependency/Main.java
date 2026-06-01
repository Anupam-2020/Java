package Field.Dependency;

public class Main {
    public static void main(String[] args) {
        Engine eng = new Engine();
        Car car = new Car();
        car.eng = eng;
        car.drive();
    }
}

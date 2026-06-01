package Setter.Dependency;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Engine eng = new Engine();
        car.setEng(eng);
        car.drive();
    }
}
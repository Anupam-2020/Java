package inheritance.example2;

public class Engine extends Car {
    @Override
    public void drive() {
        super.drive();
        System.out.println("Engine driving");
    }
}

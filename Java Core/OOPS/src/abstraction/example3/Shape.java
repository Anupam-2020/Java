package abstraction.example3;

public abstract class Shape {
    abstract double calculationArea();

    void displayArea() {
        System.out.println(
                "Area: "+ calculationArea()
        );
    }
}

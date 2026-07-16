package abstraction.example3;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculationArea() {
        return Math.PI * radius * radius;
    }
}

package OOPS;

class Shape {
    public void draw() {
        System.out.println("Shape drawn");
    }
}

class Circle extends Shape{
    public void draw() {
        System.out.println("Circle drawn");
    }
}

class Rectangle extends Shape {
    public void draw() {
        System.out.println("Rectangle drawn");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();

        Circle circle1 = new Circle();
        circle1.draw();

        Rectangle rect = new Rectangle();
        rect.draw();

        Shape shape1= new Circle(); // parent class can hold child object... (i.e -> we can access parent implementation using child object).
        Shape shape2 = new Rectangle();

        shape1.draw();
        shape2.draw();
        
//        Circle circle2 = new Shape(); // child class can't hold parent object... (i.e -> we can't access child implementation using parent class).
    }
}

package polymorphism.example1;

public class Main {
    public static void main(String[] args) {
        DisplayPoly displayPoly = new Inherited();

        displayPoly.staticFunc(); // static functions belong to class and not the object, so here the staticFunc() of displayPoly(Parent class) will be called as that is the reference and not the child object's staticFunc() method.

        Inherited inherited = (Inherited) displayPoly; // Downcasting.
        if(inherited instanceof DisplayPoly) {
            System.out.println("Instance of");
        }
    }
}

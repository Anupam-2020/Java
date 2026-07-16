package polymorphism.example2;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Cat();
//        Dog dog = (Dog) animal; // `ClassCastException`. Because animal is actually a Cat object, and you cannot cast a Cat to a Dog.

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // This line will not be executed because animal is not an instance of Dog.
            System.out.println("Animal is a Dog");
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal; // This line will be executed because animal is an instance of Cat.
            System.out.println("Animal is a Cat");
        } else {
            System.out.println("Animal is neither a Dog nor a Cat");
        }
    }
}

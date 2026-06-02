package Inheritance_4;

public class Animal { // superclass.
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal { // subclass.
    void bark() {
        System.out.println("Dog barks");
    }
}
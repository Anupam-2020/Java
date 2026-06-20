package Polymorphism_5.Runtime;


// Note for polymorphism. => private methods can't be overridden.
                // Protected, public and default specifiers need to be the same in both parent and child class.
                // Runtime polymorphism is achieved through method overriding.

public class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
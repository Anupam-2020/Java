package Super.demo_2;

public class Animal {
    String name = "Animal";

    void sound() {
        System.out.println("Animal sound");
    }

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    String name = "Dog";

    void printName() {
        System.out.println(super.name); // super calls parent instance variable.
        System.out.println(this.name); // this calls own instance variable.
    }

    Dog() {
        super(); // must be the 1st statement in child constructor.
        System.out.println("Dog constructor");
    }
}
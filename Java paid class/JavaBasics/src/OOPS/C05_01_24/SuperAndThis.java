package OOPS.C05_01_24;

class Animal {
    String dog;
}

class Dog extends Animal {

    String dog = "Shera";
    public void displayName() {
        super.dog = "Jypsy";
        System.out.println("Child dog is -> "+this.dog+" Parent dog is -> "+super.dog);
    }
}

public class SuperAndThis {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.displayName();
    }
}

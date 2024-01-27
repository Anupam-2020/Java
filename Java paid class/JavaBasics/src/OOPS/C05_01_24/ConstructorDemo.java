package OOPS.C05_01_24;

class Parent {
    Parent(int n) {
        System.out.println("I'm parent "+n);
    }
}

class Child extends Parent {
    Child() { // Parent constructor will get called by default when child object is created.
        super(10);
        System.out.println("I'm child");
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Child obj = new Child();

    }
}

package OOPS;

class A {
    public void displayFunc() {
        System.out.println("This is display A");
    }
}

class B extends A {
    public void demo() {
        super.displayFunc(); // `super` calls the parent implementation of function.
        System.out.println("----------------");
        this.displayFunc(); // `this` calls the own implementation of function.
    }
    public void displayFunc() { // function overriding
        super.displayFunc();
        System.out.println("This is display B");
    }
}

public class FunctionOverriding {
    public static void main(String[] args) {
        A obj = new A();
        obj.displayFunc();

        System.out.println("----------------");
        B obj1 = new B();
        obj1.displayFunc();
        obj1.demo();
    }
}
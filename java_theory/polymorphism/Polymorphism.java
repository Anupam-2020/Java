package polymorphism;
class A {

    public void print1() {
        System.out.println("In A print");
    }

    Polymorphism obj = new Polymorphism();
}

class B extends A {

    public void print1() {
        System.out.println("In B Print");
    }

    public String toString() { // Object class bydefault has toString() method 
        // but here we have override that method to create our own implementation...
        return "Hey";
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        // dynamic method dispatch(i.e runtime polymorphism)...
        A obj = new A();
        obj.print1();

        obj = new B();
        obj.print1();

        System.out.println(obj);
    }
}

// note:- polymorphism is of 2 types:- 
        // 1. runtime polymorphism. ( Eg- Method Overriding )
        // 2. Compile-time polymorphism. ( Eg.- Method Overloading )
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
}

public class Polymorphism {

    public static void main(String[] args) {
        A obj = new A();
        obj.print1();

        obj = new B();
        obj.print1();
    }
    
}

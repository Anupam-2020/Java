class A extends Object{
    A() {
        System.out.println("In A");
    }

    A(int n) {
        System.out.println("In A with params");
    }
}

class B extends A {
    B() {
        super(); // super() -> calls the constructor of the class which it extends....
        System.out.println("In B");
    }

    B(int n) {
        this(); // this() -> calls the constructor of same class.....
        System.out.println("In B with params");
    }
}

public class Constructors {
    public static void main(String[] args) {
        B obj = new B(5);

        new B(); // anonymous object.....
    }
}

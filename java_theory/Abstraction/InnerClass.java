// package Abstraction;
class A {
    int age;
    public void show() {
        System.out.println("In A show");
    }

    static class B {
        public void config() {
            System.out.println("In config");
        }
    }
}

abstract class C {
    public abstract void show();
}

public class InnerClass {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        // A.B obj1 = obj.new B(); // object for normal inner-class....
        A.B obj1 = new A.B(); // object for class B if B is static inner-class....
        obj1.config();

        A obj2 = new A() { // Anonymous inner class....
            public void show() {
                System.out.println("In anonymous show");
            }
        };
        obj2.show();

        C obj3 = new C() { // anonymous inner class for abstract class....
            public void show() {
                System.out.println("In anonymous config");
            }
        };
        obj3.show();
    }
}

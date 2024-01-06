package Interfaces;
// class - class -> extends
// class - interface -> implements
// interface - interface -> extends

interface A {
    void run();
    void display();
}

interface B extends A {
    void print();
}

@FunctionalInterface // a functional interface has exactly one abstract method
interface C {
    void show();
}

@FunctionalInterface
interface D {
    int disp(int i, int j);
}

class Desktop implements A,B,C { // we can implement multiple interfaces which is an addvantage over abstract class...

    public void run() {
        System.out.println("Inside run command");
    }

    public void display() {
        System.out.println("Inside show command");
    }

    public void print() {
        System.out.println("printed");
    }

    public void show() {
       System.out.println("in Show");
    }
}

public class Interfaces2 {
    public static void main(String[] args) {
        B obj = new Desktop();
        obj.print();

        Desktop obj2 = new Desktop();
        obj2.show();

        C obj1 = new C() {
            public void show() {
                System.out.println("In C show");
            }
        };

        // lambda expression -> used for functional interfaces.....
        C obj3 = () -> System.out.println("In C lambda show");
        obj3.show();
        obj1.show();

        // M-1
        // D obj4 = (i,j) -> i+j;

        // M-2
        D obj4 = (i,j) -> {
            return i + j;
        };
        System.out.println(obj4.disp(7, 8));
    }
}

// lambda expressions are only applicable for functional interfaces...
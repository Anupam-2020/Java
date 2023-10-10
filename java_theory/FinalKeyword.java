class A {
    public final void name() { // method with final key word
        System.out.println("Anupam Anand");
    }
}

class B extends A {
    public void name1() {
        System.out.println("Anurag Anand");
    }
}

public class FinalKeyword {
    public static void main(String[] args) {
        final int num = 8;
        // num = 9; variable declared with final keyword can't be re-initialised...............
        System.out.println(num); 
        A obj = new B();
        obj.name();

        // casting....
        A obj1 = (A) new B();  // upcasting.... (converting object of class B to class A).
        obj1.name();

        B obj2 = (B) obj1; // downcasting.... (converting obj1 to class B).
        obj2.name1();
    }
}

// Note:- Variable declared with `final` keyword becomes constant and can't be changed....
        // class created with `final` keyword can't be inherited...
        // function/methods with final keyword can't be overwritten to inherited class...
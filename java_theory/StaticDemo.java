class Calculator {
    static int num; // static variable
    int value; // instance variable

    int add(int num1, int num2) {
        return num1 + num2;
    }

    static { // static block for static variables.....
        num = 5; // we put the variable inside static block which we want to initialize only once.
        System.out.println("In static block");
    } 

    public Calculator() {  // constructor....
        value = 200; // here value is initialized every-time object is created.
        System.out.println("In constructor");
    }

    public static void name(Calculator cal) { // static function/method
        // We can't call a normal function/variable in static method without class reference...
        // cal.add(2,2);
        System.out.println("Static variable -> "+num+" Instance variable -> "+cal.value);
    }

    // method overloading -> (same function name but different params)................
    public int fun1(int n) {
        return n;
    }

    public int fun1(int n, int m) {
        return n+m;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        int ans = cal.add(2, 10);
        System.out.println(ans);

        Calculator cal2 = new Calculator();
        cal2.value = 4;
        Calculator.num = 3; // static class variable should be called by class and not by object of the class.......

        Calculator.name(cal2);

        // Class.forName("Calculator"); // to call static-block without calling constructor( it throws a exception so, to handle that we give throws in the main function...).
    }
}
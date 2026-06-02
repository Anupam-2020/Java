package Polymorphism_5;

public class Calculator {
    // Method overloading => same method name, different parameters...
    // overloading depends -
    //          1. No. Of parameters
    //          2. Type of parameters.
    //          3. Order of parameters.
    //          4. Same parameters but different return type => Not allowed❌

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}
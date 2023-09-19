// package inheritance;

// class Calculator {
    
//     public int add(int n1, int n2) {
//         return n1+n2;
//     }

//     public int sub(int n1, int n2) {
//         return n1 - n2;
//     }
// }

// class AdvancedCalculator extends Calculator {
//     public int multiply(int n1, int n2) {
//         return n1 * n2;
//     }

//     public int divide(int n1, int n2) {
//         return n1 / n2;
//     }
// }

public class Inheritance {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(34, 56));

        AdvancedCalculator cal2 = new AdvancedCalculator();
        System.out.println(cal2.add(34, 78));

        VeryAdvancedCalculator cal3 = new VeryAdvancedCalculator();
    }
}

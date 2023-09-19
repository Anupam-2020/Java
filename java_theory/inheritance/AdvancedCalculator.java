// package inheritance;

class AdvancedCalculator extends Calculator {
    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

    public int divide(int n1, int n2) {
        return n1 / n2;
    }

    AdvancedCalculator() {
        System.out.println("This is in advanced calculator");
    }
}

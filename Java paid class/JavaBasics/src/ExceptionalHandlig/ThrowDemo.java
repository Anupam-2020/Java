package ExceptionalHandlig;

public class ThrowDemo {
    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        try {
            throw new ArithmeticException("This is exception");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

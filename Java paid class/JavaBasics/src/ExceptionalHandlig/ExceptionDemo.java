package ExceptionalHandlig;

public class ExceptionDemo {
    public static int print() {
        try {
            System.out.println("Inside try block");
            System.out.println(10/0);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            return 20;
        }
    }

    public static void main(String[] args) {
        System.out.println(print());
    }
}

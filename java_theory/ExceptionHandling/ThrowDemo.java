package ExceptionHandling;

public class ThrowDemo {
    public static void main(String[] args) {
        int i = 0;
        int j = 2;
        try {
            if(i == 0) {
                throw new ArithmeticException("Can't divide by 0");
            }
            System.out.println(j/i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

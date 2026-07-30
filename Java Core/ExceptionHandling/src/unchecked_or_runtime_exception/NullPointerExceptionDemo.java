package unchecked_or_runtime_exception;

public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        String val = null;
        System.out.println(val.charAt(0));
    }
}

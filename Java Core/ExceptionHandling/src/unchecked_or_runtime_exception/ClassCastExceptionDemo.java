package unchecked_or_runtime_exception;

public class ClassCastExceptionDemo {
    public static void main(String[] args) {
        Object val = 0;
        System.out.println((String) val); // class java.lang.Integer cannot be cast to class java.lang.String
    }
}

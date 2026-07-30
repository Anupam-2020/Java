package unchecked_or_runtime_exception;

public class Main {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        throw new RuntimeException();
    }
}

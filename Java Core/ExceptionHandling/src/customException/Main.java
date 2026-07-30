package customException;

public class Main {
    public static void main(String[] args) {
        try {
            method1();
        } catch (MyCustomException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void method1() throws MyCustomException {
        throw new MyCustomException("some issue occurred");
    }
}

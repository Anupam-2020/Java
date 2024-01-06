package ExceptionHandling;

// throws passes the exception to parent class or class in which object is created...
// throws is used in method signature to declare an exception which might be thrown by the function...
class PassException {
    public void show() throws ClassNotFoundException {
        Class.forName("Calc");
    }
}

public class ThrowsDemo {
    public static void main(String[] args) { // we should not give throws command here, because it will pass the exception to JVM and JVM will throw exception and stop further execution...
        PassException obj = new PassException();
        try {
            obj.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

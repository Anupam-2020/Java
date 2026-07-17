package checked_or_compiletime_exception;

import java.io.FileNotFoundException;

public class ClassNotFoundExceptionDemo {
    public static void main(String[] args) { // since main is the last function to handle the exception, if main also doesn't handle it and writes throws, it is delegated to JVM and it throws respective error.
        // We're handling the exception using try/catch block. So, now main function is handling the exceptionn and it won't go to JVM.
        try {
            method1("dummy");
        } catch (ClassNotFoundException | InterruptedException e) {
            System.out.println(e.getCause().getMessage());
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        } catch (FileNotFoundException e) { // Catch here can only catch exception which can be thrown by try block. Here try block is not throwing FileNotFound Esception, so it is giving compile error.
            System.out.println(e.getMessage());
        } finally {
            System.out.println("inside finally");
        }
    }

    // Throws tells that, this method "might" throw this exception, so please handle it appropriately.
    public static void method1(String name) throws ClassNotFoundException, InterruptedException { // writing throws this way is basically delegating the exception task to the caller method. The function tells the caller method that you handle it now.
        if(name.equals("dummy")) {
            throw new ClassNotFoundException();
        }
        else if(name.equals("Interrupted")) {
            throw new InterruptedException();
        }
    }
}

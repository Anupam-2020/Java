package ExceptionHandling;
public class ExceptionHandling {
    public static void main(String[] args) {
        int i = 2;
        int j = 18;
        int arr[] = new int[5];
        try {
            System.out.println(arr[5]);
            System.out.println(j/i);
        }
        catch(ArithmeticException a) {
            System.out.println("Arithmetic Exception "+a);
        }
        catch(ArrayIndexOutOfBoundsException ar) {
            System.out.println("Stay in your limit "+ar);
        }
        catch(Exception e) { // Since Exception is parent class of above catch-classes, so we have to put it at last...
            System.out.println("Something went wrong "+ e);
        }
        finally { // finally runs in all condition. It is used to close the resource/connection
            System.out.println("This is finally block");
        }
        System.out.println(arr[0]);
    }
}

// ArrayIndexOutOfBoundsException/ ArithmeticException extends Exception.
// Exception furher extends Throwable
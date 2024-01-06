package ExceptionHandling;

class MyException extends Exception {
    public MyException(String str) {
        super(str);
    }
}


public class CustomException {
    public static void main(String[] args) {
        int i = 0;
        int j = 2;
        try {
            if(i == 0) {
                throw new MyException("Can't divide by zero");
            }
            System.out.println(j/i);
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}

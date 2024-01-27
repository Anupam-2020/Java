package OOPS;

public class FunctionOverloading {

    public static void getValue() {
        System.out.println("This is func1");
    }

    public static void getValue(String str) {
        System.out.println("This is "+str);
    }

    public static void main(String[] args) {
        getValue();
        getValue("func2");
    }
}

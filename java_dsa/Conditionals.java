import java.util.*;

public class Conditionals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value1");
        int val2 = sc.nextInt();
        System.out.println("Enter value 2");
        int val1 = sc.nextInt();
        System.out.println("Enter operator");
        String operator = sc.next();

        switch(operator) {
            case "+":
                System.out.println(val1 + val2);
                break;
            case "-":
                System.out.println(Math.abs(val1 - val2));
                break;
            case "*":
                System.out.println(val1*val2);
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }
}

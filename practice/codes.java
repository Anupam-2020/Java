import java.util.Scanner;

public class codes {
    public static void main(String[] args) {
        // literals
        // int num1 = 0b101;
        int num1 = 10_00_000;
        // System.out.println(num1);

        // Type conversion(implicit) and casting(explicit conversion)...
        int a = 13;
        byte b = (byte) a;

        // System.out.println(b);
        int result = 210;
        result = result++;
        // System.out.println(result);

        String str = result > 200 ? "Less" : result > 201 ? "Medium" : result > 202 ? "Hard" : "Zero";
        // System.out.println(str);

        // String day = "TUESDAY";
        // switch(day) {
        //     case "SUNDAY": System.out.println("It is "+day);
        //     break;
        //     case "MONDAY": System.out.println("It is "+day);
        //     break;
        //     default: System.out.println("Invalid input");
        // }

        int i = -8;
        do {
            System.out.println("Hello World "+ i);
            i--;
        } while(i > -7);
    }
}
import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        // float value = 2.4f;
        // System.out.println(value);

        byte b = 127;
        int a = 323;
        int c = a; // this is type conversion(implicit conversion).
        byte k = (byte) a; // this is type casting(explicit conversion).
        float l = 5.6f;
        int m = (int) l;
        System.out.println(m);

        // switch statement
        // Scanner sc = new Scanner(System.in);
        // String days = sc.nextLine();

        // String result;

        // M-1 traditional...
        // switch (days) {
        //     case "Monday":
        //         result = "6am";
        //         break;
        //     case "Tuesday": 
        //         result = "7am";
        //         break;
        //     default:
        //         result = "8am";
        //         break;
        // }

        // M-2 modern...
        // result = switch (days) {
        //     case "Monday" -> "6am";
        //     case "Tuesday" -> "7am";
        //     case "Wednesday" -> "8am";
        //     default -> "9am";
        // };

        // System.out.println(result);

        StringBuffer sb = new StringBuffer("Anupam");
        System.out.println(sb.capacity());
        sb.append("Anand");
        System.out.println(sb.capacity());
    }
}

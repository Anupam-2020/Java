import java.util.Scanner;
import java.util.Stack;

public class codes {

    public static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> str = new Stack<>();
        for(int i = 0; i < x.length(); i++) {
            if(x.charAt(i) == '}' && str.peek() == '{') {
                str.pop();
            } else if(x.charAt(i) == ']' && str.peek() == '[') {
                str.pop();
            } else if(x.charAt(i) == ')' && str.peek() == '(') {
                str.pop();
            } else {
                str.push(x.charAt(i));
            }
        }
        return str.empty();
    }

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

        // int i = -8;
        // do {
        //     System.out.println("Hello World "+ i);
        //     i--;
        // } while(i > -7);

        // StringBuilder strB = new StringBuilder("100100000111111101010010010011010101110110");
        // strB.setCharAt(2, 'z');
        // System.out.println(strB);
        // Math.min(2, 4);

        
        // System.out.println(ispar("("));

        System.out.println("------------------------------------------------");
        int i = 19;
        int j = 29;
        int z = i-- - i++ + --j - ++j + --i - j-- + ++i - j--;
        System.out.println(z);
    }
}

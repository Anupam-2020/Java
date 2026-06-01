import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Print hello");

        User user = new User();
        user.name = "Anupam";

        User user2 = user;
        user2.name = "Anand";

        System.out.println(user.name);

        int day = 2;
        switch (day) {
            case 1: {
                System.out.println("2nd day");
                break;
            }
            case 2:
                System.out.println("3rd day");
                break;

            default:
                System.out.println("This is default");
        }

        // reverse a number.
        int n = 1234;
        int res = 0;
        while(n > 0) {
            int d = n % 10;
            res = res * 10 + d;
            n = n / 10;
        }

        System.out.println(res);

        // check palindrome.
        int n1 = 153;
        int rev = 0;
        int i = n1;
        while(i > 0) {
            int d = i % 10;
            rev = (int) (rev + Math.pow(d,3));
            i = i / 10;
        }

        System.out.println(rev == n1);

        int x;
//        System.out.println(x);

        System.out.println(user.name + " " + user.bs + " " + user.in);

        String styr = "Anupam";
        System.out.println(styr.charAt(0));
        System.out.println(styr.substring(0, 4));

        String a = new String("Anupam");
        String b = new String("Anupam");

        System.out.println(a == b); // false.
        System.out.println(a.equals(b)); // true.

        String a1 = "Anand";
        String a2 = "Anand";

        System.out.println(a1 == a2); // true -> a1 and a2 both references to same string due to string constant pool(SCP).

        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[5];

        StringBuilder stb = new StringBuilder();

        stb.append("Anupam");
        System.out.println(stb.reverse());

        int n3= 10000;
        String str3 = "";

        long start1 = System.currentTimeMillis();

        for(int j = 1; j <= n3; j++) {
            str3+=j;
        }

        long end1 = System.currentTimeMillis();

        System.out.println("String time" + (start1 - end1) + "ms");

        StringBuilder strb = new StringBuilder();
        long start2 = System.currentTimeMillis();

        for(int j = 1; j <= n3; j++) {
            strb.append(j); // --- > amortized(O(1)).
        }

        long end2 = System.currentTimeMillis();

        System.out.println("Stringbuilder time" + (start2 - end2) + "ms");

        // In String O(n2) time complexity is required, in StringBuilder O(n) time is required for concatenation.
    }
}

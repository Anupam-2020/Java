import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class UserInputDemo {
    public static void main(String[] args) {
        System.out.println("Enter a value");
        Integer num = 0;

        // M-1 for taking input... (Not a good way for input reading)
        // try {
        //     num = System.in.read();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        // System.out.println(num - 48);

        
        // M-2 for taking the input...
        // BufferedReader bf = null;
        // try {
        //     bf = new BufferedReader(new InputStreamReader(System.in));
        //     num = Integer.parseInt(bf.readLine());
        //     bf.close();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        // System.out.println(num);


        // M-3 for taking input... ( Modern approach)
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        System.out.println(num);
        sc.close();
    }
}

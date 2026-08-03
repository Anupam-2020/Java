import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int a = print("1. Static Variable");

    static {
        print("2. static block");
    }

    int x = print("3. Instance Variable");

    {
        print("4. instance Block");
    }

    public int poly(int z) {
        return z;
    }

    public int poly(Integer z) {
        return z;
    }

    public void show(long x) {
        System.out.println(x);
    }

    public void show(Integer x) {
        System.out.println(x);
    }

    public void show(int... x) {
        System.out.println(Arrays.toString(x));
    }

    Main() {
        print("5. Constructor");
    }

    public void getVal(Integer x) {
        x = 100;
        System.out.println(x);
    }

    static int print(String s) {
        System.out.println(s);
        return 0;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main();

        Character n = 'a';
        System.out.println(m1.poly(n));

        m1.show(2,3);

        Integer a = 10;

        m2.getVal(a);

        System.out.println(a);
    }
}
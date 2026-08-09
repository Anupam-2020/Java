import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    Integer i = 0;

    Main(Integer i) {
        this.i = i;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Main m1 = new Main(2);
        Main m2 = new Main(2);

        Character n = 'a';
//        System.out.println(m1.poly(n));

        m1.show(2,3);

        Integer a = 10;

        m2.getVal(a);

//        System.out.println(a);

        String s1 = new String("String");
        String s2 = new String("String");

//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

        Address address = new Address("Hyderabad");

        Employee e1 = new Employee("Anupam",address);
        Employee e2 = (Employee) e1.clone();

//        System.out.println(e1.address == e2.address);

        Employee e3 = new Employee();
        e3.id = 1;
        e3.name = "Anupam";
        e3.address = new Address("Hyderabad");
        e3.age = 20;

        Employee e4 = new Employee();
        e4.id = 4;
        e4.name = "Anurag";
        e4.age = 9;
        e4.address = new Address("Patna");

        Employee e5 = new Employee();
        e5.id = 3;
        e5.name = "Anurags";
        e5.age = 91;
        e5.address = new Address("BiharShrif");

        List<Employee> employees = new ArrayList<>();
//        employees.add(e1);
//        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Collections.sort(employees);

//        System.out.println(employees);

        Employee e6 = new Employee();
        e6.id = 1;
        e6.age = 20;
        e6.name = "Anupam";

        e6.address = new Address("Patna");

        Employee e7 = new Employee(e6);
        e7.name = "Anurag";
//        e7.address = new Address("Hyderabad");
        e6.address = new Address("Pune");
        System.out.println(e6);
        System.out.println(e7);
    }
}
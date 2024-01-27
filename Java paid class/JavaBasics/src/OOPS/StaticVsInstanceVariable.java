package OOPS;


public class StaticVsInstanceVariable {
    int a = 10; // instance variable.
    public static void main(String[] args) {
        StaticVsInstanceVariable obj1 = new StaticVsInstanceVariable();
        StaticVsInstanceVariable obj2 = new StaticVsInstanceVariable();
        obj2.a = 20;
        System.out.println("obj2 -> "+obj2.a);
        System.out.println("obj1 -> "+obj1.a);
    }
}

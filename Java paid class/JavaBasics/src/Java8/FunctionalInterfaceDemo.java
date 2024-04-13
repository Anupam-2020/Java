package Java8;

@FunctionalInterface
interface FIDemo {
    public void m1();

    // can be overridden
    default void m2() {
        System.out.println("Default");
    }

    // Can't be overridden
    static void m3() {
        System.out.println("Static");
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FIDemo.m3();
        FIDemo fd = () -> System.out.println("This is fd");
        fd.m2();
        fd.m1();
        FIDemo fd2 = new FIDemo() { // same as the above lambda function.
            @Override
            public void m1() {
                System.out.println("This is m1 default");
            }
        };
        fd2.m1();
    }
}

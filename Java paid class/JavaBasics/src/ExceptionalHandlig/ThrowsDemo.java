package ExceptionalHandlig;

public class ThrowsDemo {
    public static void main(String[] args) throws InterruptedException{
        m1();
    }

    public static void m1() throws InterruptedException{
        System.out.println("In M1");
        m2();
        System.out.println("Bye M1");
    }

    public static void m2() throws InterruptedException{
        System.out.println("In M2");
        m3();
        System.out.println("Bye M2");
    }

    public static void m3() throws InterruptedException {
        System.out.println("In M3");
        Thread.sleep(1000);
        System.out.println("Bye M3");
    }
}

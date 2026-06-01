package Singleton;

public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Object created");
    }

    public static Singleton getInstance() {
        return instance;
    }
}

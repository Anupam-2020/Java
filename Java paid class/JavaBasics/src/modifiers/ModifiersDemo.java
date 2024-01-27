package modifiers;

class Protected1 {
    int a = 100;
}

public class ModifiersDemo {
    protected int b = 200;
    protected int getValue() {
        return b;
    }

    public static void main(String[] args) {
        Protected1 p = new Protected1();
        System.out.println(p.a);
    }
}

package modifiers.C22_01_24forProtected;

import modifiers.ModifiersDemo;

class Protected2 extends ModifiersDemo {
//    @Override
//    protected int getValue() {
//        System.out.println(b);
//        return super.getValue();
//    }
}

public class ProtectedDemo extends Protected2 {
    public static void main(String[] args) {
        ProtectedDemo pr = new ProtectedDemo();
        System.out.println(pr.b);
        pr.getValue();
    }
}

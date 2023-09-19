class Calc {
    public int add(int n1, int n2) {
        return n1 + n2;
    }
}

class AdvCalc extends Calc {
    public int add(int n1, int n2) {
        return n1+n2+1;
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        AdvCalc cal = new AdvCalc();
        System.out.println(cal.add(3, 5));
    }
}
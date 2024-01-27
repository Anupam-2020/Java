package OOPS.C07_01_24;

public class VarArgsDemo {
    public static void sum(int ...x) { // var-args help to achieve function overloading...
        int sum = 0;
        for(int i : x) {
            sum+=i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        sum(10);
        sum(10,10,10);
        sum(12,13,14,3);
    }
}

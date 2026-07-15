package polymorphism.example1;

public class DisplayPoly {
    void display(int x) {
        System.out.println(x);
    }

    void display(Integer x) { // Int is called because exact primitive match is preferred over auto-boxing.
        System.out.println("Wrapper: "+x);
    }

    void display(int ...x) { // varargs.
        System.out.println("Varargs: "+x);
    }

    public static void staticFunc() {
        System.out.println("From DisplayPoly");
    }
}

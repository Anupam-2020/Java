package This.demo_1;

public class Test {
    void show() {
        System.out.println("Show method");
    }

    void display() {
        System.out.println("Print test data");
        this.show();
    }
}
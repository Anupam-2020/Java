package This.demo_1;

public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        this("Anupam", 23); // `this` represents Student(String name) constructor.
        // Note:- this() must be the 1st statement inside the constructor;
    }

//    public static void main(String[] args) {
//        Test te = new Test();
//        te.display();
//    }
}

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s = new Student("hello", 28);
        Map<Student, String> h = new HashMap<>();
        h.put(s, "A");
        Student s1 = new Student("Hello", 28);
        System.out.println(h.get(s1));

        List<Integer> list = new Stack<>();
    }
}


class Student {
    String name;
    Integer age;

    Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
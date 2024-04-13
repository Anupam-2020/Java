package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    int id;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    String name;
    int marks;
}

public class StreamDemo {
    public static void main(String[] args) {
//        List<Integer> ls = new ArrayList<>();
//        ls.add(2);
//        ls.add(4);
//        ls.add(10);
//        ls.add(12);
//
////        ls.stream().filter(i-> i > 5).forEach(i-> System.out.println(i)); // M-1
//        ls.stream().filter(i->i>5).forEach(System.out::println); // M-2
//
//        List<Integer> collect = ls.stream().filter(i->i>5).collect(Collectors.toList());
//        System.out.println(collect);
//
//        ls.stream().map(i->i+1000).forEach(System.out::println);
//
////        Optional<Integer> res = ls.stream().max((o1, o2) -> o1.compareTo(o2)); // M-1
//        Optional<Integer> res = ls.stream().min(Integer::compareTo); // M-2
//        System.out.println(res);

        List<Student> studentList = Arrays.asList(
            new Student(1, "Anupam", 80),
            new Student(2, "Anand", 74)
        );

        List<Student> st = studentList.stream()
                .sorted(Comparator.comparingInt(Student::getMarks)).collect(Collectors.toList());
        System.out.println(st);
    }
}

package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student> { // either we use Comparator functional-interface or we make the class Comparable...
    String name;
    Integer roll;

    Student(int roll, String name) {
        this.name = name;
        this.roll = roll;
    }

    public String toString() {
        return "Student [age=" + roll + ", name="+ name+"]";
    }

    @Override
    public int compareTo(Student o) {
        if(this.roll > o.roll) {
            return 1;
        } else return -1;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(10);
        // arr.add(56);
        // arr.add(11);
        // arr.add(64);

        // Comparator<Integer> comp = new Comparator<>() { // comparator is used for making sort function in our own way. 
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         if(o1%10 > o2%10) {
        //             return 1;
        //         } else {
        //             return -1;
        //         }
        //     }
        // };

        // Collections.sort(arr, comp);
        // System.out.println(arr);

        ArrayList<Student> stud = new ArrayList<>();
        stud.add(new Student(15, "Anand"));
        stud.add(new Student(12, "Anupam"));

        // Comparator<Student> comp = new Comparator<Student>() { // comparator is also used when Data-type is not `Comparable`...
        //     @Override
        //     public int compare(Student i, Student j) {
        //         return i.roll > j.roll ? 1 : -1;
        //     }
        // };

        Collections.sort(stud);
        System.out.println(stud);
    }
}

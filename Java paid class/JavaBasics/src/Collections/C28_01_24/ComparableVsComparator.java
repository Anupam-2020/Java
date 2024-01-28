package Collections.C28_01_24;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;


class Student implements Comparable {
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    int id;
    String name;

    @Override
    public String toString() {
        return "Student [id= "+ id + " , name = "+name+" ]";
    }

    @Override
    public int compareTo(Object ob) {
        Student o = (Student) ob;
//        System.out.println(((Student) ob).id);
        System.out.println(this.id);
        return Integer.compare(this.id, o.id);
    }
}

class MyComp implements Comparator { // we use comparator when we have our own compare implementation

    public MyComp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id;
    String name;

    public MyComp() {

    }

    @Override
    public int compare(Object o1, Object o2) {
        MyComp m1 = (MyComp) o1;
        MyComp m2 = (MyComp) o2;
        if(m1.id > m2.id) {
            return 1;
        } else if(m1.id == m2.id) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        SortedSet<Integer> sorted = new TreeSet<>(); // here integer implements comparable...
        sorted.add(20);
        sorted.add(12);
        sorted.add(15);
        System.out.println(sorted);

        SortedSet<Student> sortedStud = new TreeSet<>(); // here `Student class` doesn't implement comparable that's why we need to manually implement...
        sortedStud.add(new Student(12, "Anupam"));
        sortedStud.add(new Student(11, "Anurag"));
        System.out.println(sortedStud);

        // *****************************************************************************
        // Apart from implementing comparable we can also implement comparator interface.
         SortedSet<MyComp> comp = new TreeSet<>(new MyComp()); // for comparator, we need to add a class object here as well.
        comp.add(new MyComp(12, "Anupam"));
        comp.add(new MyComp(11, "Anurag"));
        System.out.println(sortedStud);
    }
}

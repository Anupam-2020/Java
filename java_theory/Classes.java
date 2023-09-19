class Student {
    String name;
    int rollNo;
    static int marks; // statically declared variable becomes member of the class and can be called by
                      // class only and not by object.....

    public static void getData(Student s) { // we can take the static variable directly in static function but can't take normal variables directly.....
        System.out.println(s.name + " " + marks + " " + s.rollNo);
    }
}

public class Classes {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Anupam";
        // s1.marks = 98;
        Student.marks = 98;
        s1.rollNo = 10;

        Student s2 = new Student();
        s2.name = "Anand";
        // s2.marks = 94;
        s2.rollNo = 12;

        Student sArr[] = new Student[2]; // this will create an array which will contain the reference of
                                         // object(student)....

        sArr[0] = s1;
        sArr[1] = s2;

        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i].name + " " + sArr[i].marks);
        }

        for (Student i : sArr) {
            System.out.println(i.name + " " + i.marks);
        }

        Student.getData(s2);
    }
}

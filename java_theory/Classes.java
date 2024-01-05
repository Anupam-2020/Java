class Student {
    String name;
    int rollNo;
    static int marks; // statically declared variable becomes member of the class and can be called by
                      // class only and not by object.....

    public static void getData(Student s) { // we can take the static variable directly in static function but can't take normal variables directly.....
        System.out.println(s.name + " " + marks + " " + s.rollNo);
    }
}

class Marks {
    String stud;
    String roll;
    int marks;
}

public class Classes {
    public static void main(String[] args) {

        // Array of object
        Marks mw1 = new Marks();
        mw1.marks = 89;
        mw1.roll = "12232";
        mw1.stud = "Anurag";

        Marks mw2 = new Marks();
        mw2.marks = 91;
        mw2.roll = "12233";
        mw2.stud = "Anupam";

        Marks mw[] = new Marks[2];
        mw[0] = mw1;
        mw[1] = mw2;

        for(Marks stud: mw) {
            System.out.println(stud.marks+ " " + stud.roll + " " + stud.stud);
        }

        // ---------------------------------------------------------------------------------

        
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

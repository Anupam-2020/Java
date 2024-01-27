package OOPS.C05_01_24;

// Type casting is the process of converting value of one type to another type.
// implicit type-casting -> conversion of value from lower type to higher type.
// explicit type-casting -> conversion of value from high type to lower type.( data loss ).

// up-casting -> conversion of child ref. to parent ref.
// down-casting -> conversion of parent ref. to child ref.

class ParentUp {

}

class ChildDown extends ParentUp{

}

public class TypeCasting {
    public static void main(String[] args) {
        int b = 1000;
        byte a = (byte) b; // explicit type-casting.
        System.out.println(a);

        ParentUp obj = new ParentUp();
        obj = (ParentUp) new ChildDown(); // up-casting

        ChildDown obj1 = (ChildDown) obj; // down-casting
    }
}

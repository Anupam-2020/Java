package Collections.C27_01_24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class A implements Cloneable {

    int a;
    @Override
    public A clone() {
        try {
            return (A) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class CollectionDemo {
    public static void main(String[] args) {
        A ls = new A();
        ls.a = 10;
        A cloneObject = ls.clone(); // clone() is used to create the clone of object. Clone() comes from Cloneable interface...
        cloneObject.a = 20;
        System.out.println("ls -> "+ls.hashCode()+" value of a -> "+ls.a);
        System.out.println("cloneable -> "+cloneObject.hashCode()+" value of cloneObject -> "+cloneObject.a);

        // ************************************************************************************************
        List<Integer> list = new ArrayList<>(); // arraylist implements interface called as RandomAccess which helps arraylist to access any array-element in O(1) time...
        list.add(10);
        list.add(20);
        list.add(30);

        List<Integer> list1 = new ArrayList<>();
        list1.add(30);
        list1.add(40);
        list1.add(50);

        System.out.println(list.addAll(list1));
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer integer = it.next();
            System.out.print(integer+" ");
        }

        for(Integer li: list) {
            System.out.println(li);
        }

        System.out.println(list.contains(30));
    }
}

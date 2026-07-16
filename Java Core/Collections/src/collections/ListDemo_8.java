package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo_8 {
    public static void main(String[] args) {

        // List is an interface, so we cannot create an object of it.
        // List<Integer> list = new List<>(); // This will give an error.

        // We can use ArrayList or LinkedList to create a list.
        List<Integer> list1 = new ArrayList<>();
        list1.add(0, 100);
        list1.add(1, 200);
        list1.add(2, 300);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0, 400);
        list2.add(1, 500);
        list2.add(2, 600);

        list1.addAll(2, list2);
        list1.forEach(System.out::println);

        list1.replaceAll(val -> -1 * val);
        System.out.println("after replace all");
        list1.forEach(System.out::println);

        list1.sort((val1, val2) -> Integer.compare(val2, val1)); // decreasing order...
        System.out.println("after sorting in decreasing order");
        list1.forEach(System.out::println);

        System.out.println("value present at index 2: "+ list1.get(2));

        // set
        list1.set(2, -4000);
        System.out.println("After updating 2nd index: ");
        list1.forEach(System.out::println);

        // need to provide the index in listIterator, from which it has to start.
        ListIterator<Integer> listIterator1 = list1.listIterator(list1.size());

        // traversing backward direction.
        while (listIterator1.hasPrevious()) {
            int prevVal = listIterator1.previous();
            System.out.println("traversing backward: " + prevVal + " nextIndex: " + listIterator1.hasNext() + " previous index: " + listIterator1.previousIndex());
            if(prevVal == -100) listIterator1.set(-50);
        }

        System.out.println("After set: ");
        list1.forEach(System.out::println);

        // Thread safe version of ArrayList.
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0, 100);
        System.out.println(list);

        // Vector is same as ArrayList, but it's thread safe.
        Vector<Integer> vector = new Vector<>();
        vector.add(0,2);
        vector.add(1, 3);

        // Note:- Stack extends vector is also thread safe...
    }
}

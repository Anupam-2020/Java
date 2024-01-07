package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> values = new HashSet<>(); // HashSet -> stores values in random order...
        // Set<Integer> values = new TreeSet<>(); // TreeSet -> stores values in ascending order...

        values.add(21);
        values.add(32);
        values.add(11);
        values.add(13);
        values.add(102);

        Iterator<Integer> itr = values.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        // for(int i : values) {
        //     System.out.println(i);
        // }
    }
}

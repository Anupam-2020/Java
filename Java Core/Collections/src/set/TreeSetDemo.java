package set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    // TreeSet can't store null values.
    // Average Time complexity - O(log n) for insertion, deletion, iteration.
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(2);
        treeSet.add(77);
        treeSet.add(82);
        treeSet.add(6);
        treeSet.add(21);

        Iterator<Integer> iterator = treeSet.iterator();

        while(iterator.hasNext()) {
            int val = iterator.next();
            System.out.println(val);
        }
    }
}

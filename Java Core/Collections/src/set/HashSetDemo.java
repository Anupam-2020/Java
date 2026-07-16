package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HashSetDemo {
    // HashMap is not thread safe. If multiple threads access a hash map concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally.
    // Order of elements is not guaranteed in HashSet. It does not maintain the insertion order of elements. The order may change over time as elements are added or removed.
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1); // Under the hood it uses HashMap to store the values. The value is stored as key in the map and the value is a constant object.
        // map.put(1, new Object());

        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(100);

        // Union of two sets
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union of set1 and set2: " + unionSet);

        set1.retainAll(set2);
        System.out.println("Intersection of set1 and set2: " + set1);


        Iterator<Integer> iterator1 = set1.iterator();
        while(iterator1.hasNext()) {
            int val = iterator1.next();
            if(val == 4) set1.add(9); // throws error as it is not thread safe.
        }

        set1.forEach(System.out::println);

        // ThreadSafe set.
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Set<Integer> threadSafeSet = concurrentHashMap.newKeySet();
        threadSafeSet.add(2);
        threadSafeSet.add(1);

        Iterator<Integer> iterator = threadSafeSet.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            if(val == 1) threadSafeSet.add(9);
        }

        threadSafeSet.forEach(System.out::println);
    }
}

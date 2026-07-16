package set;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    // Here, insertion order is maintained but unlike LinkedHashMap, access order is not maintained.
    // LinkedHashSet is not thread safe.
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();

        // Thread safe hashSet.
        Set<Integer> set1 = Collections.synchronizedSet(new LinkedHashSet<>());
        set1.add(2);
    }
}

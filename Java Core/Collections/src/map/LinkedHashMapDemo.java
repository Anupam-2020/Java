package map;

import java.util.*;

public class LinkedHashMapDemo {
    // LinkedHashMap maintains the insertion order of the elements, while HashMap does not guarantee any specific order.
    // In a LinkedHashMap, the elements are stored in a doubly-linked list, which allows for predictable iteration order. In contrast, HashMap uses a hash table, which can result in a different order of elements each time you iterate over it.
    // LinkedHashMap is not thread safe. You can use Collections.synchronizedMap() to make it thread-safe.
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75F, true);
        linkedHashMap.put(1, "A");
        linkedHashMap.put(21, "B");
        linkedHashMap.put(33, "C");
        linkedHashMap.put(145, "D");
        linkedHashMap.put(25, "E");
        linkedHashMap.forEach((key, val) -> System.out.println(key + " : " + val));
        linkedHashMap.get(21);
        System.out.println("-------------------- after accessing key 21");
        linkedHashMap.forEach((key, val) -> System.out.println(key + " : " + val));

        System.out.println("-------------------- below id normal hashmap output");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(21, "B");
        hashMap.put(33, "C");
        hashMap.put(145, "D");
        hashMap.put(25, "E");
        hashMap.forEach((key, val) -> System.out.println(key + " : " + val));

        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(linkedHashMap);
        synchronizedMap.put(1, "A");
        synchronizedMap.put(21, "B");
        synchronizedMap.get(21);
        System.out.println("-------------------- after accessing key 21 in synchronized map");
    }
}

package map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreemapDemo {
    // TreeMap is a sorted map implementation that stores key-value pairs in a red-black tree.
    // It maintains the keys in sorted order, either based on their natural ordering or according to a specified comparator.
    // TreeMap provides log(n) time complexity for basic operations like get, put, and remove.
    // Usually slower than HashMap and LinkedHashMap due to the overhead of maintaining the sorted order, but it is useful when you need to keep the keys sorted or perform range queries.
    public static void main(String[] args) {
        SortedMap<Integer, String> treeMap = new TreeMap<>((key1, key2) -> key2 - key1); // Custom comparator for descending order
        treeMap.put(1, "A");
        treeMap.put(21, "B");
        treeMap.put(33, "C");
        treeMap.put(145, "D");
        treeMap.put(25, "E");

        treeMap.forEach((key, val) -> System.out.println(key + " : " + val));

        System.out.println(treeMap.headMap(21)); // Returns a view of the portion of this map whose keys are strictly greater than 21
        System.out.println(treeMap.tailMap(21)); // Returns a view of the portion of this map whose keys are less than or equal to 21
        System.out.println(treeMap.firstKey()); // Returns the first (lowest) key currently in this map.
        System.out.println(treeMap.lastKey()); // Returns the last (highest) key currently in this map.
        System.out.println(treeMap.size()); // Returns the number of key-value mappings in this map.
        System.out.println(treeMap.isEmpty()); // Returns true if this map contains no key-value mappings.
        System.out.println(treeMap.containsKey(21)); // Returns true if this map contains a mapping for the specified key.
        System.out.println(treeMap.containsValue("B")); // Returns true if this map maps one or more keys to the specified value.
    }
}

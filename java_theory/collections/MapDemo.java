package collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

// HashMap	vs Hashtable
// 1) HashMap is non synchronized. It is not-thread safe and can't be shared between many threads without proper synchronization code.	
// Hashtable is synchronized. It is thread-safe and can be shared with many threads.

// 2) HashMap allows one null key and multiple null values.	
// Hashtable doesn't allow any null key or value.

// 3) HashMap is a new class introduced in JDK 1.2.	
// Hashtable is a legacy class.

// 4) HashMap is fast.	
// Hashtable is slow.

// 5) We can make the HashMap as synchronized by calling this code
// Map m = Collections.synchronizedMap(hashMap);	
// Hashtable is internally synchronized and can't be unsynchronized.

// 6) HashMap is traversed by Iterator.	
// Hashtable is traversed by Enumerator and Iterator.

// 7) Iterator in HashMap is fail-fast.	Enumerator in Hashtable is not fail-fast.
// 8) HashMap inherits AbstractMap class.	Hashtable inherits Dictionary class.


public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> studs = new HashMap<>();
        Map<String, Integer> students = Collections.synchronizedMap(studs); // to make students synchronized...
        // Map<String, Integer> studs = new Hashtable<>();

        students.put("Anupam", 89);
        students.put("Rahul", 90);
        students.put("Siddharth", 91);
        students.put(null, 23);
        students.put(null, 45);
        students.put(null, 42);

        System.out.println(students);

        // System.out.println(students.get("Anupam")); // returns value associated with the key. And if no such key is there then returns null... 
        // System.out.println(students.keySet()); // returns array of keys...
        // System.out.println(students.values()); // returns array of values...
        
        for(int value: students.values()) {
            System.out.print(value+" ");
        }
    }
}

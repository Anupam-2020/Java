package map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // HashMap is not thread safe.
        // Hash Table is thread safe. It is synchronized hashMap.
        // Concurrent HashMap is also thread safe.

        Map<Integer, String> rollNumberVsNameMap = new HashMap<>();
        rollNumberVsNameMap.put(null, "TEST");
        rollNumberVsNameMap.put(0, null);
        rollNumberVsNameMap.put(1, "A");
        rollNumberVsNameMap.put(2, "B");

        // compute if present.
        rollNumberVsNameMap.putIfAbsent(null, "test");
        rollNumberVsNameMap.putIfAbsent(0, "ZERO");
        rollNumberVsNameMap.putIfAbsent(3, "C");

        for (Map.Entry<Integer, String> entryMap: rollNumberVsNameMap.entrySet()) {
            Integer key = entryMap.getKey();
            String value = entryMap.getValue();
            System.out.println("Key: " + key + " value: " + value);
        }

        // isEmpty
        System.out.println("isEmpty(): " + rollNumberVsNameMap.isEmpty());

        // size
        System.out.println("size: " + rollNumberVsNameMap.size());

        // containsKey
        System.out.println("contains key(3): " + rollNumberVsNameMap.containsKey(3));

        // get(key)
        System.out.println("get(9): " + rollNumberVsNameMap.get(2));

        // keySet() -> returns a array of keys
        for(Integer key: rollNumberVsNameMap.keySet()) {
            System.out.println("key: " + key);
        }

        // values() -> returns a array of values
        Collection<String> values = rollNumberVsNameMap.values();
        for(String value: values) {
            System.out.println("value: " + value);
        }
    }
}

package Collections.C28_01_24;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Map doesn't allow duplicate keys.
// Map is an unordered Data Structure.
// Only one null key is allowed.
// If we try to put values with the same key, then values will be over-written.

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(12, "Anupam");
        map.put(null, "null value");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Iterator<Integer> it1 = map.keySet().iterator();
        while (it1.hasNext()) {
            Integer i = it1.next();
            System.out.print("Key = "+i);
            System.out.println(" ,Value = "+map.get(i));
        }
    }
}

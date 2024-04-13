package Collections.C18_02_24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(40);
        System.out.println(hashSet);

        int[] arr = {10,10,20,40,10,30,50,10,20,30};

        // to count the duplicates in array......................................
//        for(int i = 0; i < arr.length-1; i++) {
//            int count = 1;
//            if(arr[i] == -1) continue;
//            for(int j = i+1; j < arr.length; j++) {
//                if (arr[i] == arr[j] && arr[j] != -1) {
//                    arr[j] = -1;
//                    count++;
//                }
//            }
//            System.out.println(arr[i]+" => "+count);
//        }

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for(int i : arr) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
//            map.merge(i, 1, Integer::sum);
        }
//        System.out.println(map);

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            map.put(23,34);
        }
    }
}

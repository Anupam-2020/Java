import java.util.HashMap;
import java.util.Map;

public class CountPairInArray {
    public static void main(String[] args) {
        int arr[] = {1,5,7,-1};
        int key = 6;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(key - arr[i])) {
                count+=map.get(key - arr[i]);
            }
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        System.out.println(count);
    }
}
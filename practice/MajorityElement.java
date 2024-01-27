import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    static int majorityElementOptimized(int []arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) > arr.length/2) {
                return arr[i];
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(majorityElementOptimized(new int[]{1,3,5,1,2,1,1}));
    }
}

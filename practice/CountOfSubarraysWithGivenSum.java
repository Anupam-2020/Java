import java.util.HashMap;
import java.util.Map;

public class CountOfSubarraysWithGivenSum {

    static int countOfArrays(int arr[], int k) {
        int count = 0;
        int curr_sum = 0;
        Map<Integer, Integer> prevSum = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            curr_sum = curr_sum + arr[i];
            if(curr_sum == k) count++;
            if(prevSum.containsKey(curr_sum - k)) {
                count = count + prevSum.get(curr_sum - k);
            }
            prevSum.put(curr_sum, prevSum.getOrDefault(curr_sum, 0)+1);
        }
        System.out.println(prevSum);
        return count;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,-1,0};
        System.out.println(countOfArrays(arr, 0));
    }
}

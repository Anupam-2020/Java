import java.util.HashMap;

public class FirstNonRepeatingElementInArray {
    public static int firstNonRepeating(int arr[], int n) { // optimised. 
        // Complete the function
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(map.get(arr[i])==1) return arr[i];
        }
        return 0;
    }

    public static int firstNonRepeating2(int arr[], int n) { // brute force 
        // Complete the function
        if(n == 1) return arr[0];
        for(int i = 0; i < arr.length-1; i++) {
            int flag = 0;
            if(arr[i] == Integer.MIN_VALUE) continue;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    arr[j] = Integer.MIN_VALUE;
                    flag = 1;
                }
                if(arr[j] == Integer.MIN_VALUE) continue;
            }
            if(flag == 0) {
                return arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(firstNonRepeating(new int[]{-1, 2, -1, 3, 2}, 5));
    }
}

import java.util.ArrayList;

public class MaxSumSubarrayWithGivenSize {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){ // optimised...
        // code here
        long sum = 0;
        for(int i = 0; i < K; i++) { // first calculate the sum of 1st K elements.
            sum+=Arr.get(i);
        }
        
        long curr_sum = sum;
        for(int i = K; i < N; i++) {
            curr_sum += Arr.get(i) - Arr.get(i - K); // now add next elements and subtract the previous elements...
            if(curr_sum > sum) sum = curr_sum;
        }
        return sum;
    }

    static long maximumSumSubarray2(int K, ArrayList<Integer> Arr,int N){ // brute force...
        // code here
        long maxSum = Long.MIN_VALUE;
        for(int i = 0; i <= N - K; i++) { // if N is size then loop will iterate till N-K elements...
            long sum = 0;
            for(int j = i; j < K+i; j++) {
                sum+=Arr.get(j);
            }
            if(sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        
    }
}

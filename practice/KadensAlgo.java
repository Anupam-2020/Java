public class KadensAlgo {
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int currSum = 0;
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
                endIndex = i;
            }

            if(currSum < 0) {
                currSum = 0;
                startIndex = i+1;
            }
        }
        for(int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(maxSum);
    }
}

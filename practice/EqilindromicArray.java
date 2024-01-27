import java.util.Arrays;

public class EqilindromicArray {
    static boolean checkPalindrome(long num) {
        String str = Long.toString(num);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static long minimumCost(int[] nums) {
        Arrays.sort(nums);
        long min = nums[0];
        long max = nums[nums.length-1];
        long mid = nums[nums.length/2];
        long minCost = Long.MAX_VALUE;

        long midValue = mid;
        while(!checkPalindrome(midValue)) {
            midValue--;
        }
        min = midValue;

        midValue = mid;
        while(!checkPalindrome(midValue)) {
            midValue++;
        }
        max = midValue;

        for(long i: new long[]{min, max}) {
            long count = 0;
            for(int j = 0; j < nums.length; j++) {
                long diff = Math.abs(nums[j] - i);
                count+=diff;
            }
            if(count < minCost) {
                minCost = count;
            }
            System.out.println(i);
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1,2,3,4,5}));
        String str = new String("Anupam");
        String str2 = new String("Anupam");
        System.out.println(str.equals(str2));
    }
}

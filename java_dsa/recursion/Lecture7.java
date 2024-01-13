import java.util.ArrayList;

public class Lecture7 {

    public static void subarrayOfAGivenSum(int index, int arr[], ArrayList<Integer> arr1, int s, int sum) {
        if(index == arr.length) {
            if(s == sum) {
                for(int ele : arr1) System.out.print(ele+" ");
                System.out.println();
            }
            return;
        }

        arr1.add(arr[index]);
        s+=arr[index];
        subarrayOfAGivenSum(index+1, arr, arr1, s, sum);
        arr1.remove(arr1.size() - 1);
        s-=arr[index];
        subarrayOfAGivenSum(index+1, arr, arr1, s, sum);
    }

    public static boolean print_only_one_subarray_of_a_given_sum(int index, int arr[], ArrayList<Integer> arr1, int s, int sum) {
        if(index == arr.length) {
            if(s == sum) {
                for(int ele : arr1) System.out.print(ele+" ");
                System.out.println();
                return true;
            }
            return false;
        }

        arr1.add(arr[index]);
        s+=arr[index];
        if(print_only_one_subarray_of_a_given_sum(index+1, arr, arr1, s, sum) == true) return true;
        arr1.remove(arr1.size() - 1);
        s-=arr[index];
        if(print_only_one_subarray_of_a_given_sum(index+1, arr, arr1, s, sum) == true) return true;
        return false;
    }

    public static int countOfSubarraysOfAGivenSum(int index, int arr[], int s, int sum) {
        if(s > sum) return 0;
        if(index == arr.length) {
            if(s == sum) return 1;
            return 0;
        }

        s+=arr[index];
        int l = countOfSubarraysOfAGivenSum(index+1, arr, s, sum);
        s-=arr[index];
        int m = countOfSubarraysOfAGivenSum(index+1, arr, s, sum);
        return l + m;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,0};
        ArrayList<Integer> arr1 = new ArrayList<>();
        // subarrayOfAGivenSum(0, arr, arr1, 0, 3);
        // print_only_one_subarray_of_a_given_sum(0, arr, arr1, 0, -1);
        // System.out.println(countOfSubarraysOfAGivenSum(0, arr, 0, 3));
    }
}

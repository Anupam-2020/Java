import java.util.ArrayList;

public class Lecture6 {

    public static void subarray(int arr[], ArrayList<Integer> arr1, int index) {
        if(index >= arr.length) {
            for(int i : arr1) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        arr1.add(arr[index]);
        subarray(arr, arr1, index + 1);
        arr1.remove(arr1.size() - 1);
        subarray(arr, arr1, index + 1);
    }

    

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        ArrayList<Integer> arr1 = new ArrayList<>();
        subarray(arr, arr1, 0);
    }
}

public class RotateArrayToLeft {
    static void reverseArray(int arr[], int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static void rotateArrByK(int arr[], int k, int n) {
        // add your code here
        k = k % n; // in case if d > size of array(n)...
        k = n - k; 
        reverseArray(arr, 0, n-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, n-1);
    }


    public static void main(String[] args) {
        // rotate array counter-clockwise...
        rotateArrByK(new int[]{1,2,3,4,5}, 2, 5); // expected output -> 3,4,5,1,2... 
    }
}

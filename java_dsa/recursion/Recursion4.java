import java.util.Arrays;

public class Recursion4 {
    public static String reverseString(String str) {
        if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static boolean checkPalindrome(String str, int i) {
        if(str.length() == i) return true;
        if(str.charAt(i) != (str.charAt(str.length() - 1 - i))) return false;
        return checkPalindrome(str, i+1);
    }

    public static long powerOfANumber(int number, int power) {
        if(power == 0) return 1;
        if(power == 1) return number;

        long ans = powerOfANumber(number, power/2);

        if(power%2 == 0) return ans * ans;
        else return number * ans * ans;
    }

    public static void bubbleSortUsingRecursion(int arr[], int index) {
        // base condition....
        if(index == arr.length - 1) return;
        int count = 0; // if array is already sorted the return without looping through the array...
        for(int i = 0; i < arr.length - index - 1; i++) {
            if(arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        if(count == 0) return;
        bubbleSortUsingRecursion(arr, index+1);
    }

    public static void selectionSortUsingRecursion(int arr[], int index) {
        if(index == arr.length - 1) return;

        int min = index;
        for(int i = index+1; i < arr.length; i++) {
            if(arr[i] < arr[min]) {
                min = i;
            }
        }
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;

        selectionSortUsingRecursion(arr, index+1);
    }

    public static void insertionSortUsingRecursion(int arr[], int index) {
        if(index == arr.length) {
            return;
        }

        int currIndex = arr[index];
        int j = index - 1;
        while(j >= 0 && currIndex < arr[j]) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = currIndex;

        insertionSortUsingRecursion(arr, index+1);
    }

    public static void merge(int arr[], int start, int end) {

        // set the mid point.
        int mid = start + (end - start) / 2;

        // set the size of the arrays based on mid point of arr...
        int len1 = mid - start + 1;
        int len2 = end - mid;

        // Declaring temporary arrays...
        int tempArr1[] = new int[len1];
        int tempArr2[] = new int[len2];

        // putting values in the array...
        int mainArrayIndex = start;
        for(int i = 0; i < len1; i++) {
            tempArr1[i] = arr[mainArrayIndex++];
        }

        System.out.println( "temp1 -> " + Arrays.toString(tempArr1));

        mainArrayIndex = mid + 1;
        for(int i = 0; i < len2; i++) {
            tempArr2[i] = arr[mainArrayIndex++];
        }

        System.out.println( "temp2 -> " +Arrays.toString(tempArr2));

        // sorting in main array.
        int index1 = 0;
        int index2 = 0;
        int k = start;
        while(index1 < len1 && index2 < len2) {
            if(tempArr1[index1] <= tempArr2[index2]) {
                arr[k] = tempArr1[index1];
                index1++;
            }

            else {
                arr[k] = tempArr2[index2];
                index2++;
            }
            k++;
        }

        // putting remaining elements of array1 in main array....
        while(index1 < len1) {
            arr[k++] = tempArr1[index1++];
        }

        // putting remaining elements of array2 in main array....
        while(index2 < len2) {
            arr[k++] = tempArr2[index2++];
        }
    }

    public static void mergeSortUsingRecursion(int arr[],int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start)/2;
        mergeSortUsingRecursion(arr, start, mid);
        mergeSortUsingRecursion(arr, mid+1, end);
        merge(arr, start, end);
    }

    public static int partition(int arr[], int start, int end) {
        int pivot = arr[start];

        int count = 0;
        for(int i = start; i <= end; i++) {
            if(arr[i] < pivot) count++;
        }

        int pivotIndex = start+count;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[start];
        arr[start] = temp;

        int i = start, j = end;
        while(i < pivotIndex && j > pivotIndex) {
            while(arr[i] <= pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }
            if(i < pivotIndex && j > pivotIndex) {
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    public static void quickSortUsingRecursion(int arr[], int start, int end) {
        if(start >= end) return;
        int p = partition(arr, start, end);
        quickSortUsingRecursion(arr, start, p-1);
        quickSortUsingRecursion(arr, p+1, end);
    }

    public static void main(String[] args) {
        // System.out.println(reverseString("anupam"));
        // System.out.println(checkPalindrome("an", 0));
        // System.out.println(powerOfANumber(3, 0));

        int arr[] = {50,30,40,0,70,10,90,0};
        // bubbleSortUsingRecursion(arr, 0);
        // selectionSortUsingRecursion(arr, 0);
        // insertionSortUsingRecursion(arr, 1);
        // mergeSortUsingRecursion(arr, 0, arr.length - 1);
        // quickSortUsingRecursion(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Recursion3 {

    public static void reverseInGroups(int arr[], int n, int k) {

        int i = 0;
        int m = k - 1;
        int j = m;
        int temp;

        while (m <= n - 1) {
            while (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            i = m + 1;
            m = m + k;
            j = m;
        }

        // i = m + 1;
        j = n - 1;
        while (i <= j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        for (int l = 0; l < n; l++) {
            System.out.print(arr[l] + " ");
        }
    }

    public static int missingNumber(int array[], int n) {
        // Your Code Here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n - 1; i++) {
            arr.add(array[i]);
        }
        Collections.sort(arr);
        
        for(int i = 0; i < n - 1; i++) {
            array[i] = arr.get(i);
        }
        
        for(int i = 0; i < n - 1; i++) {
            if(array[i] != i+1) {
                return i+1;
            }
        }
        return 0;
    }

    public static void sayNumber(int num, String arr[]) {
        if(num == 0) {
            return ;
        }

        int digit = num % 10;
        num = num / 10;
        sayNumber(num, arr);

        System.out.print(arr[digit]+" ");
    }

    public static boolean checkForSortedArray(int arr[], int index) {
        if(index == arr.length - 1) {
            return true;
        }

        if(arr[index] > arr[index+1]) {
            return false;
        }
        return checkForSortedArray(arr, index+1);
    }

    public static int sumOfArray(int arr[], int index) {
        if(index == arr.length) {
            return 0;
        }

        return arr[index] + sumOfArray(arr, index+1);
    }

    public static void linearSearch(int arr[], int key, int index) {
        if(index == arr.length) {
            System.out.println("Key not found");
            return;
        }

        if(arr[index] == key) {
            System.out.println("Key found");
            return;
        }

        linearSearch(arr, key, index+1);
    }

    public static void binarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(arr[mid] == key) {
                System.out.println(mid);
                return;
            }
            if(arr[mid] < key) {
                start = mid+1;
            } 
            else if(arr[mid] > key) {
                end = mid-1;
            }
            mid = (start + end) / 2;
        }
        System.out.println("Key not found");
    }

    public static void binarySearchUsingRecursion(int arr[], int key, int start, int end) {
        if(start > end) {
            System.out.println("Key not found");
            return;
        }

        int mid = (start + end)/2;
        if(arr[mid] == key) {
            System.out.println("found at -> "+mid);
            return;
        }

        else if(arr[mid] > key) {
            binarySearchUsingRecursion(arr, key, start, mid-1);
        }

        else {
            binarySearchUsingRecursion(arr, key, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1,3,8,16,17,19 };
        // reverseInGroups(arr, 5, 3);
        // ArrayList<Integer> arr1 = new ArrayList<>();
        // arr1.add(3);
        // arr1.add(5);
        // arr1.add(1);
        // System.out.println(arr1.size()); 
        // Collections.sort(arr1);
        // System.out.println(arr1);
        // System.out.println(missingNumber(arr, 5));
        
        String stringArr[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        // sayNumber(345,stringArr);

        // System.out.println(checkForSortedArray(arr, 0));

        // System.out.println(sumOfArray(arr, 0));
        // linearSearch(arr, 2, 0);
        // binarySearch(arr, 9);
        // binarySearchUsingRecursion(arr, 1, 0, arr.length - 1);
    }
}

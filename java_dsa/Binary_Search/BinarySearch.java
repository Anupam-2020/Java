public class BinarySearch {

    public static void binarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        // int mid = (start + end) / 2;
        int mid = start + (end - start) / 2; // Optimised approach....

        while (start <= end) {
            if (arr[mid] == key) {
                System.out.println(mid);
                return;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        System.out.println("Key not found");
    }

    public static void binarySearchUsingRecursion(int arr[], int key, int start, int end) {
        if (start > end) {
            System.out.println("Key not found");
            return;
        }

        // int mid = (start + end)/2;
        int mid = start + (end - start) / 2; // Optimised approach....
        if (arr[mid] == key) {
            System.out.println("found at -> " + mid);
            return;
        }

        else if (arr[mid] > key) {
            binarySearchUsingRecursion(arr, key, start, mid - 1);
        }

        else {
            binarySearchUsingRecursion(arr, key, mid + 1, end);
        }
    }

    public static void firstOccuranceOfKeyInArray(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        int store = 0;
        while(start <= end) {
            if(arr[mid] == key) {
                store = mid;
                end = mid - 1;
            }

            if(arr[mid] > key) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }

        System.out.println("first occurance -> " +store);
    }

    public static void lastOccuranceOfKeyInArray(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        int store = 0;

        while(start <= end) {
            if(arr[mid] == key) {
                store = mid;
                start = mid + 1;
            }

            else if(arr[mid] > key) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;

        }

        System.out.println("last occurance -> " + store);
    }

    public static void peakInMountain(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start)/2;

        while(start < end) {
            if(arr[mid] > arr[mid+1]) {
                end = mid;
            } 

            else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        System.out.println("peak in the mountain -> "+start);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 8, 8, 8, 19, 8 };
        binarySearch(arr, 1);
        binarySearchUsingRecursion(arr, 1, 0, arr.length - 1);
        firstOccuranceOfKeyInArray(arr, 8);
        lastOccuranceOfKeyInArray(arr, 8);
        peakInMountain(arr);
    }
}

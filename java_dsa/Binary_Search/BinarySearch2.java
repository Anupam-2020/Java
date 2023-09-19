import java.util.Scanner;

public class BinarySearch2 {
    public static void findPeakOfAMountain(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start)/2;

        while(start < end) {
            if(arr[mid] < arr[mid+1]) start = mid+1;
            else end = mid;
            mid = start + (end - start) / 2;
        }
        System.out.println(start);
    }

    public static int findPivotOfRotatedArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start)/2;

        while(start < end) {
            if(arr[mid] >= arr[0]) start = mid + 1;
            else end = mid;
            mid = start + (end - start)/2;
        }
        return start;
    }

    public static int binarySearch(int arr[], int key, int beg, int finish) {
        int start = beg;
        int end = finish;
        int mid = start + (end - start) / 2;
        while(start <= end) {
            if(arr[mid] == key) return mid;

            else if(arr[mid] > key) end = mid - 1;

            else start = mid + 1;

            mid = start + (end - start) / 2;
        }
        return -1;
    }

    public static void findElementInARotatedSortedArray(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int pivot = findPivotOfRotatedArray(arr);
        int digit = -1;
        if(key >= arr[0]) digit = binarySearch(arr, key, start, pivot - 1);

        else digit = binarySearch(arr, key, pivot, end);

        System.out.println(digit);
    }

    public static int squareRoot(int num) {
        int start = 0;
        int end = num;
        int mid = start + (end - start)/2;
        int squareRoot = 0;
        while(start <= end) {
            if(mid * mid <= num) {
                squareRoot = mid;
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        
        return squareRoot;
    }

    public static void preciseSquareRoot(int precisionValue, int number, int tempSol) {
        double value = 1;
        double ans = tempSol;
        for(int i = 0; i < precisionValue; i++) {
            value = value / 10;
            for(double j = ans; j*j < number; j = j + value) {
                ans = j;
            }
        }
        System.out.println(ans);
    }



    public static void main(String[] args) {
        int mountain[] = {3,7,8,1,2};
        // findPeakOfAMountain(mountain);
        // System.out.println(findPivotOfRotatedArray(mountain));
        // findElementInARotatedSortedArray(mountain, 8);
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter number whose square root is to be found out");
        // int number = sc.nextInt();
        // int ans = squareRoot(number);
        // System.out.println(ans);
        // preciseSquareRoot(3, number, ans);
    }
}

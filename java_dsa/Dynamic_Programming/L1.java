// package java_dsa.Dynamic_Programming;

import java.util.ArrayList;

public class L1 {
    static int fibonacci(int num, int arr[]) { // memoization
        if(num <= 1) {
            return num;
        }

        if(arr[num] != -1) {
            return arr[num];
        } else {
            return arr[num] = fibonacci(num-1, arr) + fibonacci(num - 2, arr);
        }
    }

    public static void main(String[] args) {
        int req = 6;
        int arr[] = new int[req+1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        System.out.println(fibonacci(req, arr));
    }
}

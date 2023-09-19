import java.util.Scanner;

public class Sorting {

    public static void bubbleSort(int arr[]) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter array size");
        // int size = sc.nextInt();
        // int arr[] = new int[size];
        // System.out.println("Enter array elements");
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = sc.nextInt();
        // }
        
        int arr[] = {7,6,3,1,2};
        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
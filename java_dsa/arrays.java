import java.util.ArrayList;
import java.util.Scanner;

public class arrays {
    public static void searchANumber(int array[], int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                System.out.println("key = " + i);
                break;
            }
        }
    }

    public static void stringArray(String array[]) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void arraySortingCheck(int array[]) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length - 1; i++) {
            min = array[i];
            if(array[i+1] < min) {
                System.out.println("Not sorted");
                break;
            }
        }
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> emptyList = new ArrayList<>();
        emptyList.add(-1);
        
        
        int i = 0;
        int j = 0;
        int currentSum = 0;
        while(i < arr.length && j < arr.length) {
            if(currentSum < s) {
                currentSum = currentSum + arr[i];
                i++;
            } else if(currentSum > s) {
                currentSum = currentSum - arr[j];
                j++;
            } else {
                array.add(j+1);
                array.add(i);
                break;
            }
        }
        if(array.isEmpty()) {
            return emptyList;
        }
        return array;
    }

    public static void main(String[] args) {
        // int[] marks = new int[3]; // M-1 for array
        // declaration..............................
        // int marks[] = {97,98,99}; // M-2 for array
        // declaration.............................
        // int marks[] = new int[3]; // M-3 for array declaration......................

        // Scanner sc = new Scanner(System.in);
        // for(int i = 0; i < marks.length; i++) {
        // marks[i] = sc.nextInt();
        // }

        // for(int i = 0; i < marks.length; i++) {
        // System.out.println(marks[i]);
        // }

        // System.out.println("Enter size of array");
        // int size = sc.nextInt();

        // int numbers[] = new int[size];
        // System.out.println("Enter elements");
        // for (int i = 0; i < numbers.length; i++) {
        //     numbers[i] = sc.nextInt();
        // }

        // int search = 67;
        // searchANumber(numbers, search);

        // arraySortingCheck(numbers);

        // System.out.println("Enter size of array");
        // int size = sc.nextInt();
        // String names[] = new String[size];
        // System.out.println("Enter names");
        // for(int i = 0; i < size; i++) {
        //     names[i] = sc.nextLine();
        // }
        // stringArray(names);
        int array[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(subarraySum(array, 10, 19));
    }
}

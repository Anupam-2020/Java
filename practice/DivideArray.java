import java.util.Arrays;

public class DivideArray {
    static int[][] divideArrayProblem(int arr[], int k) {
        Arrays.sort(arr);
        int length = arr.length;
        int res[][] = new int[length/3][3];
        int l = 0;
        for(int i = 0; i  < arr.length; i+=3) {
            if(Math.abs(arr[i] - arr[i+2]) > k) {
                return new int[][]{};
            }
            res[l++] = new int[]{arr[i], arr[i+1], arr[i+2]};
        }
        return res;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,3,4,8,7,9,3,5,1};
        int k = 6;
        int res[][] = divideArrayProblem(arr, k);
        for(int[] i: res) {
            for(int j: i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

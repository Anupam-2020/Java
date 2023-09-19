import java.util.Scanner;

public class arrays2d {

    public static void searchingKeyIn2dArray(int arr[][],int rows, int col, int key) {
        for(int i = 0; i< rows; i++) {
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == key) {
                    System.out.println("row -> "+i + " "+" column -> " +j);
                    break;
                }
            }
        }
    }

    public static void transposeOfAMatrix(int arr[][], int row, int col) {
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows and columns");
        int rows = sc.nextInt();
        int col = sc.nextInt();
        int arr[][] = new int[rows][col];

        System.out.println("Enter elements");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

         int key = 34;
         searchingKeyIn2dArray(arr, rows, col,key);

        // transposeOfAMatrix(arr, rows, col);


    }
}

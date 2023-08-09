import java.util.Scanner;

public class loops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // do-while loop...........................................
        // int i = 0;
        // do {
        // System.out.println(i);
        // i++;
        // } while(i < 11);

        // sum of n consecutive numbers................................................
        // int count = sc.nextInt();
        // System.out.println((count*(count+1))/2);

        // table of a number........................................
        // int table = sc.nextInt();
        // int i = 1;
        // while( i <= 10) {
        // System.out.println(table+" * "+i+" = "+table*i);
        // i++;
        // }

        // pattern printing.......
        int x = sc.nextInt();
        int y = sc.nextInt();
        // pattern - 1...........................................................

        // *****
        // *****
        // *****
        // *****

        // for(int i = 0; i < x; i++) {
        // for(int j = 0; j < y; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // pattern - 2............................................................

        // *****
        // *   *
        // *   *
        // *   *
        // *****

        // for(int i = 1; i <= x; i++) {
        // for(int j = 1; j <= y; j++) {
        // if( i == 1 || i == x || j == 1 || j == y) {
        // System.out.print("*");
        // }
        // else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }

        // pattern - 3.............................................................

        // *
        // **
        // ***
        // ****

        // for(int i = 1; i <= x; i++) {
        // for(int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // pattern - 4..........................................................

        // ****
        // ***
        // **
        // *

        // for(int i = x; i >= 1; i--) {
        // for(int j = 1; j <=i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // pattern - 5......................................................

        // *
        // **
        // ***
        // ****

        // for(int i = x; i >= 1; i--) {
        // for(int j = 1; j <= x; j++ ) {
        // if(j >= i) {
        // System.out.print("*");
        // }
        // else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }

        // pattern - 6.......................................................
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4

        // for( int i = 1; i <= x; i++) {
        // for(int j = 1; j <= i; j++) {
        // System.out.print(j);
        // }
        // System.out.println();
        // }

        // pattern - 7...........................................................
        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1

        // M-1..................................
        // for(int i = x; i >= 1; i--) {
        // for(int j = 1; j <= i; j++) {
        // System.out.print(j);
        // }
        // System.out.println();
        // }

        // M-2....................................
        // for(int i = 1; i <= x; i++) {
        // for(int j = 1; j <= x-i+1; j++) {
        // System.out.print(j);
        // }
        // System.out.println();
        // }

        // pattern - 8.........................................................

        // 1
        // 2 3
        // 4 5 6
        // 7 8 9 10

        // int sum = 0;
        // for(int i = 1; i <= x; i++) {
        // for(int j = 1; j <= i; j++) {
        // sum++;
        // System.out.print(sum+" ");
        // }
        // System.out.println();
        // }

        // pattern - 9......................................................

        // 1
        // 0 1
        // 1 0 1
        // 0 1 0 1
        // 1 0 1 0 1

        // for(int i = 1; i <= x; i++) {
        // for(int j = 1; j <= i; j++) {
        // int count = i + j;
        // if(count % 2 == 0) {
        // System.out.print(1+" ");
        // }
        // else {
        // System.out.print(0+" ");
        // }
        // }
        // System.out.println();
        // }

        // pattern - 10....................................................

        // *      *
        // **    **
        // ***  ***
        // ********
        // ********
        // ***  ***
        // **    **
        // *      *

        // upper half
        // for (int i = 1; i <= x; i++) {
        //     // first part
        //     // stars
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     // spaces
        //     for (int j = i; j < x; j++) {
        //         System.out.print(" ");
        //     }

        //     // second part
        //     // spaces
        //     for (int j = i; j < x; j++) {
        //         System.out.print(" ");
        //     }

        //     // stars
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // // lower half
        // for (int i = x; i >= 1; i--) {
        //     // first part
        //     // stars
        //     for (int j = 1; j <= x; j++) {
        //         if (j <= i) {
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }

        //     // second part
        //     for (int j = x-1; j >= i; j--) {
        //         System.out.print(" ");
        //     }

        //     for (int j = 1; j <= x; j++) {
        //         if (j <= i) {
        //             System.out.print("*");
        //         }
        //     }
        //     // spaces
        //     System.out.println();
        // }

        // pattern - 11....................................................
        //     *****
        //    *****
        //   *****
        //  *****
        // ***** 

        // for(int i = 1; i <= x; i++) {
        //     // spaces
        //     for(int j = 1; j <= x - i; j++) {
        //         System.out.print(" ");
        //     }
        //     // stars
        //     for(int j = 1; j <= x; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // pattern - 12..........................................................
        //     *****
        //    *   *
        //   *   * 
        //  *   *
        // ***** 

        // for(int i = 1; i <= x; i++) {
        //     for(int j = 1; j <= x - i; j++) {
        //         System.out.print(" ");
        //     }

        //     for(int j = 1; j <= x; j++) {
        //         if(i == 1 || j == 1 || i == x || j == x) {
        //             System.out.print("*");
        //         }
        //         else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }

        // pattern - 13...................................................
        //     1
        //    2 2
        //   3 3 3
        //  4 4 4 4
        // 5 5 5 5 5

        // for(int i = 1; i <= x; i++) {
        //     // spaces
        //     for(int j = 1; j <= x - i; j++) {
        //         System.out.print(" ");
        //     }

        //     // numbers
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        // pattern - 14.....................................................
        //        1
        //       212
        //      32123
        //     4321234
        //    543212345

        // for(int i = 1; i <= x; i++) {
        //     for(int j = 1; j <= (x - i); j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = i; j >= 1; j--) {
        //         System.out.print(j);
        //     }
        //     for(int j = 2; j <= i; j++) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // pattern - 15....................................................

        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *

        // upper triangle
        for(int i = 1; i <= x; i++ ) {
            for(int j = 1; j <= x - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // lower triangle
        for(int i = x-1; i >= 1; i--) {
            for(int j = 1; j <= x - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

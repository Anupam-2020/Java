import java.util.ArrayList;

public class Recursion5 {
    public static void printPermutation(String str, String permutation) {
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutation(newStr, permutation+currChar);
        }
    }

    public static int numberOfPathsInMaze(int m, int n, int i, int j) {
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        return numberOfPathsInMaze(m, n, i+1, j) + numberOfPathsInMaze(m, n, i, j+1);
    }

    public static int arrange_tiles_on_floor(int n, int m) {
        if(n == m) return 2;
        if(n < m) return 1;
        return arrange_tiles_on_floor(n - m, m) + arrange_tiles_on_floor(n - 1, m);
    }

    public static int inviting_guests_with_pair(int numberOfGuests) {
        if(numberOfGuests <= 1) return 1;

        return inviting_guests_with_pair(numberOfGuests - 1) + (numberOfGuests - 1) * inviting_guests_with_pair(numberOfGuests - 2);
    }

    public static void subsetOfAnArray(int n, ArrayList<Integer> subset) {
        if(n == 0) {
            System.out.println(subset);
            return;
        }
        subset.add(n);
        subsetOfAnArray(n-1, subset);

        subset.remove(subset.get(subset.size() - 1));
        subsetOfAnArray(n-1, subset);
    }

    public static int solveCircularGameProblem(int n, int k) {
        if(n == 1) {
            return 0;
        }

        return (solveCircularGameProblem(n-1, k) + k) % n;
    }

    public static int findWinnerInCircularGame(int n, int k) {
        int ans = solveCircularGameProblem(n, k) + 1;
        return ans;
    }

    public static float doubleEffect(int days, float moneyInvestedInitially) {
        if(days == 1) {
            return moneyInvestedInitially;
        }
        return doubleEffect(days-1, moneyInvestedInitially*2);
    }

    public static void main(String[] args) {
        // printPermutation("abc", "");
        // System.out.println(numberOfPathsInMaze(3, 4, 0,0));
        // System.out.println(arrange_tiles_on_floor(4, 2));
        // System.out.println(inviting_guests_with_pair(3));
        // ArrayList<Integer> subset = new ArrayList<>();
        // subsetOfAnArray(3, subset);
        // System.out.println(findWinnerInCircularGame(5, 2));
        System.out.println(doubleEffect(31, 0.01f));
    }
}

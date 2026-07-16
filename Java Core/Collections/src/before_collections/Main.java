package before_collections;

import java.util.List;
import java.util.Vector;

public class Main {
    // Before collections there was no common interface, so it's difficult to remember the methods for each.
    public static void main(String[] args) {
        int[] arr = new int[4];

        arr[0] = 1;

        int val = arr[0];

        Vector<Integer> vector = new Vector<>();

        vector.add(1);
        vector.get(0);
    }
}

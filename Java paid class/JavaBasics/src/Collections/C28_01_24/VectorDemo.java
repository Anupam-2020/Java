package Collections.C28_01_24;

// Vector vs ArrayList
// 1. Vector is thread-safe but arraylist is not.
// 2. Capacity of vector = 2 * old capacity.
// 2. Capacity of arraylist = 1.5 * old capacity.

import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        System.out.println(vector.capacity());
        for(int i = 0; i < 11; i++) {
            vector.add(i+1);
        }
        System.out.println(vector.capacity());
        Enumeration<Integer> en = vector.elements(); // enumeration is used for legacy classes like vector...
        while (en.hasMoreElements()) {
            Integer integer = en.nextElement();
            System.out.print(integer+" ");
        }
    }
}

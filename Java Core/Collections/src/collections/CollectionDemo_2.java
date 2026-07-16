package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollectionDemo_2 {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(2);
        values.add(3);
        values.add(4);

        System.out.println("size: "+values.size()); // 3
        System.out.println("isEmpty: "+values.isEmpty()); // false
        System.out.println("contains: "+values.contains(5)); // false

        values.add(5);
        System.out.println("added: "+values.contains(5)); // true

        values.remove(3);
        System.out.println(values.contains(5)); // false

        values.remove(Integer.valueOf(3));
        System.out.println("removed using object"+values.contains(3)); // false

        Stack<Integer> stackValues = new Stack<>();
        stackValues.add(6);
        stackValues.add(7);
        stackValues.add(8);

        values.addAll(stackValues);
        System.out.println("addAll test using containsAll: "+values.containsAll(stackValues));// true.

        values.remove(Integer.valueOf(7));
        System.out.println("containsAll after removing 1 element: "+ values.containsAll(stackValues)); // false

        values.removeAll(stackValues);
        System.out.println("removeAll: "+values);

        values.clear();
        System.out.println("clearAll: "+values);

    }
}

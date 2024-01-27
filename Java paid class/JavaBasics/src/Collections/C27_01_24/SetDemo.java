package Collections.C27_01_24;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        // Set doesn't follow the order in which we give the values...
        // Set does not allow duplicates...
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(40);
        System.out.println(set);
        set.remove(30);
        System.out.println(set);
    }
}

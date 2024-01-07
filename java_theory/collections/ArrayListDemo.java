package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> name = new ArrayList<Integer>();
        name.add(1);
        name.add(2);
        name.add(4);
        name.add(-1);

        Iterator<Integer> values = name.iterator();

        while (values.hasNext()) {
            System.out.println(values.next());
        }
    }
}

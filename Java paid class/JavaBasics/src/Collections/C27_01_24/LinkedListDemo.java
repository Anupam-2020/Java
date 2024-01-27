package Collections.C27_01_24;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(); // unlike arraylist LinkedList doesn't implement RandomAccess...
        linkedList.add(20);
        linkedList.add(40);
        System.out.println(linkedList);
    }
}

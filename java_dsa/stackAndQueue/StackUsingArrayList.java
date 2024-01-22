// package stackAndQueue;

import java.util.ArrayList;

public class StackUsingArrayList {
    static ArrayList<Integer> list = new ArrayList<>();

    public static int push(int num) {
        list.add(num);
        return num;
    }

    static boolean isEmpty() {
        return list.size() == 0 ? true : false;
    }

    static int pop() {
        return list.size() > 0 ? list.remove(list.size() - 1) : -1;
    }

    static int peek() {
        return list.size() > 0 ? list.get(list.size() - 1) : -1;
    }

    public static void main(String[] args) {
        push(10);
        System.out.println(peek());
    }
}

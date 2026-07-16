package queue;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Dequeue_7 {
    public static void main(String[] args) {
        // Deque => Double ended queue means addition and removal can be done from both the sides of the queue.

        ArrayDeque<Integer> arrayDequeAsQueue = new ArrayDeque<>();

        // Insertion
        arrayDequeAsQueue.addLast(1);
        arrayDequeAsQueue.addLast(2);
        arrayDequeAsQueue.addLast(10);

        //Deletion
        int element = arrayDequeAsQueue.removeFirst();
        System.out.println(element);

        // LIFO
        ArrayDeque<Integer> arrayDequeAsStack = new ArrayDeque<>();
        arrayDequeAsStack.addFirst(1);
        arrayDequeAsStack.addFirst(2);
        arrayDequeAsStack.addFirst(12);

        //deletion
        Integer removedEle = arrayDequeAsStack.removeFirst();
        System.out.println(removedEle);

        // Thread safe version of deque -> It helps in concurrent programming where multiple threads can access the same data structure without causing data inconsistency by using locks or other synchronization mechanisms.
        ConcurrentLinkedDeque<Integer> ob = new ConcurrentLinkedDeque<>();
        ob.addFirst(2);
        ob.addFirst(3);
        System.out.println(ob.removeLast());
    }
}

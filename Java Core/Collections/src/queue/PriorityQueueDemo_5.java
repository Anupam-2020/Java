package queue;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueDemo_5 {
    public static void main(String[] args) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // if we don't provide anything in the constructor then it'll take min heap.
        minPQ.add(5);
        minPQ.add(2);
        minPQ.add(8);
        minPQ.add(1);

        minPQ.forEach(val -> System.out.println(val));

        while (!minPQ.isEmpty()) {
            int val = minPQ.poll();
            System.out.println("remove from top: "+val);
        }

        // Thread safe version of priority queue ->
        PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<>();
        pq.add(5);
        pq.add(3);
        System.out.println(pq.peek());
    }
}

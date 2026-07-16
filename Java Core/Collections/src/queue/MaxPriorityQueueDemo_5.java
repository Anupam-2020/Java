package queue;

import java.util.PriorityQueue;

public class MaxPriorityQueueDemo_5 {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        maxPQ.add(5);
        maxPQ.add(2);
        maxPQ.add(8);
        maxPQ.add(1);

        maxPQ.forEach(val -> System.out.println(val));

        while (!maxPQ.isEmpty()) {
            int val = maxPQ.poll();
            System.out.println("remove from top: "+val);
        }
    }
}

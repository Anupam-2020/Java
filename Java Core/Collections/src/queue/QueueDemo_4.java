package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo_4 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2); // Inserts element into queue. `True` if insertion is successful. `Exception` if insertion fails.
        queue.offer(3); //  Inserts element into queue. `True` if insertion is successful. `False` if insertion fails.
        queue.poll(); // // retrieves and removes the value present at the head of queue. Returns null if queue is empty.
        queue.remove(); // retrieves and removes the value present at the head of queue. Returns Exception if Queue is empty.
        queue.peek(); // only retrieves the value present at the head of queue.
    }
}

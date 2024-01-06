// A race condition occurs when two or more threads can access shared data and they try to change it at the same time. 
// Because the thread scheduling algorithm can swap between threads at any time, 
// you don't know the order in which the threads will attempt to access the shared data. 
// Therefore, the result of the change in data is dependent on the thread scheduling algorithm, i.e. both threads are "racing" to access/change the data.

class Counter {
    int counter;
    public synchronized void increment() { // synchronized makes the method thread-safe by making it call by only one thread at a time...
        // synchronized is one way to avoid race condition 
        counter++;
    }
}

public class RaceCondition {
    public static void main(String[] args) {
        Counter obj1 = new Counter();

        Runnable obj2 = new Runnable() {
            public void run() {
                for(int i = 0; i < 5000; i++) {
                    obj1.increment();
                }
            }
        };

        Runnable obj3 = new Runnable() {
            public void run() {
                for(int i = 0; i < 5000; i++) {
                    obj1.increment();
                }
            }
        };

        Thread t1 = new Thread(obj2);
        Thread t2 = new Thread(obj3);

        t1.start();
        t2.start();


        try { // join() is used to make sure when both t1 and t2 joins at a point then only further execution proceeds.
            t1.join();
            t2.join();

        } catch(Exception e) {

        }

        System.out.println(obj1.counter);
    }
}

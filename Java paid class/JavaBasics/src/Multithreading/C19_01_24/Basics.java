package Multithreading.C19_01_24;

// Note: - A component of Java that decides which thread to run or execute and which thread to wait is called a thread scheduler in Java.
//        In Java, a thread is only chosen by a thread scheduler if it is in the runnable state.
//        However, if there is more than one thread in the runnable state, it is up to the thread scheduler to pick one of the threads and ignore the other ones.
//        There are two factors for scheduling a thread, i.e., Priority and Time of arrival.
//      Priority:- Priority of each thread lies between 1 and 10. If a thread has a higher priority, it means that thread has got a better chance of getting picked up by the thread scheduler.
//                  1 - MIN_PRIORITY
//                  2.- NORM_PRIORITY
//                  3.- MAX_PRIORITY
//      Time of arrival: - If two threads of the same priority but one takes lesser time to execute, then that will show up.


//class MultithreadingDemo extends Thread {
//    @Override
//    public void run() {
////        for (int i = 0; i < 10; i++) {
////            System.out.println("This is Macbook");
////        }
//        System.out.println(Thread.currentThread().getName());
//    }
//}

class MultithreadingDemo implements Runnable { // better way.
    @Override
    public void run() { // run method is used to assign a job.
        Thread.currentThread().setPriority(10);
        for(int i = 0; i < 10; i++) {
            System.out.println("This is macbook");
        }
    }
}

public class Basics {
    public static void main(String[] args) {
        MultithreadingDemo demo = new MultithreadingDemo();
//        demo.start();
//        for(int i = 0; i < 10; i++) {
//            System.out.println("Jai Shri Ram");
//        }

//        for (int i = 0; i < 10; i++) {
//            MultithreadingDemo demo = new MultithreadingDemo();
//            demo.start();
//        }

        Thread t1 = new Thread(demo);
        t1.start(); // start method is used to create a new thread for the job.
        for (int i = 0; i < 10; i++) {
            System.out.println("Jai shri ram");
        }

//        System.out.println(t1.getName());
//        System.out.println(Thread.currentThread().getName());

//        System.out.println("t1 priority: - "+t1.getPriority());
//        System.out.println("main priority: - "+Thread.currentThread().getPriority());
    }
}
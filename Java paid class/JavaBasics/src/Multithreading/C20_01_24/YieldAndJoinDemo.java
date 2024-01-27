package Multithreading.C20_01_24;

class ThreadDemo2 extends Thread {
    Thread t1;
    ThreadDemo2(Thread t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
//                t1.join(); // join will wait for t1 to finish, then further code will execute...
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Child thread2: "+Thread.currentThread().getName());
        }
    }
}

class ThreadDemo implements Runnable {
    @Override
    public void run() {
//        Thread.yield(); // yield stops/pause the main thread for a temporary basis.

        for (int i = 0;  i < 5; i++) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
            System.out.println("Child Thread: "+Thread.currentThread().getName());
        }
    }
}

public class YieldAndJoinDemo {
    public static void main(String[] args) throws InterruptedException {

        ThreadDemo thread = new ThreadDemo();
        Thread t1 = new Thread(thread);
        ThreadDemo2 t2 = new ThreadDemo2(t1);
        t1.start();
        t2.start();
//        t2.interrupt(); // this will interrupt the thread t2.
        t2.join(); // join will wait for t2 to finish, then further code will execute...
        for (int i = 0;  i < 5; i++) {
            System.out.println("Main Thread: " + Thread.currentThread().getName());
        }
    }
}

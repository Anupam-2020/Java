package thread_lifecycle;

public class ThreadLife {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(() -> { // -> At this point, no new operating-system-level execution has started.
            System.out.println("Running");
        });

        System.out.println(thread.getState()); // NEW

        thread.start();
        System.out.println(thread.getState()); // RUNNABLE

        ShareResource resource = new ShareResource();

        Thread thread1 = new Thread(() -> resource.process(), "Thread-1");
        Thread thread2 = new Thread(() -> resource.process(), "Thread-2");

        thread1.start();
        thread2.start();

        Thread.sleep(500);

        System.out.println("Thread-1 state: " + thread1.getState());
        System.out.println("Thread-2 state: " + thread2.getState());

        thread1.join();
        thread2.join();

        System.out.println("Thread-1 state: " + thread1.getState());
        System.out.println("Thread-2 state: " + thread2.getState());
    }
}

class ShareResource {
    synchronized void process() {
        try {
            System.out.println(Thread.currentThread().getName() + " Entered process");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " Completed process");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}

package thread_lifecycle;

public class SynchronizedExample {
    private int count = 0;
    synchronized void counter() {
        count++;
    }

    int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();

        Thread thread1 = new Thread(example::counter);
        Thread thread2 = new Thread(() -> example.counter());
        Thread thread3 = new Thread(() -> {
            for(int i = 0; i < 100_100; i++) {
                example.counter();
            }
        });

        thread3.start();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(example.getCount());
    }
}

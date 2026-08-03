public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task executed: " + Thread.currentThread().getName());
    }
}

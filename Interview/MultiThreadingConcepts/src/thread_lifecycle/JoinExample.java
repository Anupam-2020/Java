package thread_lifecycle;

public class JoinExample {
    public static void main(String[] args) {
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Worker started");
                    Thread.sleep(3000);
                    System.out.println("Worker finished");
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        worker.start();

        System.out.println("Main is waiting");

        try {
            worker.join(2000); // Main waits for either worker to terminate or 2000ms to pass.
        } catch (InterruptedException e) {
            throw new Error(e);
        }

        System.out.println("Main continues");
    }
}

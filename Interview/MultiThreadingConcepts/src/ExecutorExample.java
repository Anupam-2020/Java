import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
//        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++) {
            int taskNumber = i;

            service.submit(() -> System.out.println("Task " + taskNumber +  " executed by " + Thread.currentThread().getName()));
        }

        service.shutdown(); // Shuts down the executor service, preventing new tasks from being submitted. Previously submitted tasks are executed, but no new tasks will be accepted.
        service.shutdownNow(); // Interrupts all running tasks and stops accepting new tasks. Previously submitted tasks are attempted to be stopped, but no new tasks will be accepted.
    }
}

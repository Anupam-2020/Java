import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        System.out.println("Process ID: "+ ProcessHandle.current().pid());
        System.out.println("Current Thread: " + Thread.currentThread().getName());

        // M-1 of creating thread using lambda function which is coming from thread's run method.
//        Thread worker = new Thread(() -> System.out.println("Worker Thread: " + Thread.currentThread().getName()));
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Worker Thread: " + Thread.currentThread().getName());
            }
        });
        worker.start();

        // // M-2 of creating thread by extending thread class.
        MyThread thread = new MyThread();
        thread.start();

        // M-3 of creating thread by implementing Runnable interface.
        MyTask task = new MyTask();
        Thread thread1 = new Thread(task);

        thread1.start();

        Thread thread2 = new Thread(() -> System.out.println("Thread executed using lambda: " + Thread.currentThread().getName()));

        thread2.start();

        // M-4 of creating thread using Executor service.
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> System.out.println("Task executed by executor: " + Thread.currentThread().getName()));

        executor.shutdown(); // Shuts down the executor service, preventing new tasks from being submitted. Previously submitted tasks are executed, but no new tasks will be accepted.

        // M-5 of creating thread using Callable and Future.
        ExecutorService service = Executors.newSingleThreadExecutor();
        Callable<Integer> task2 = () -> { // Callable is a functional interface that represents a task that can be executed by a thread and returns a result.
            // It is similar to Runnable, but it can return a value and throw checked exceptions.
            return 10 + 20;
        };

        Future<Integer> future = service.submit(task2);

        try {
            Integer result = future.get(); // future.get() waits until the result becomes available.
            System.out.println("result: " + result);
            service.shutdown();
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }

    }
}
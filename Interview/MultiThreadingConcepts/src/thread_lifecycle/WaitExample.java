package thread_lifecycle;

public class WaitExample {

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread consumer = new Thread(() -> resource.consume(), "Consumer");

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000);
                resource.produce();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();

        consumer.join();
        producer.join();
    }
}

class SharedResource {
    private boolean dataAvailable = false;

    synchronized void consume() {
        try {
            while(!dataAvailable) {
                System.out.println("Consumer is waiting");
                wait(); // Releases this object's monitor lock.
            }

            System.out.println("Consumer received the data");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    synchronized void produce() {
        System.out.println("producer is producing data");

        dataAvailable = true;

        notify(); // wakes one thread waiting on this object.
    }
}

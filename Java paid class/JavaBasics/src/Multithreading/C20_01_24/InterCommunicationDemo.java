package Multithreading.C20_01_24;

// when there are multiple threads related to each other, then we called it as inter-thread communication.
class ThreadDemo3 extends Thread {
    int sum = 0;
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Child thread starts.");
            for (int i = 0; i < 500; i++) {
                sum += i;
            }
            System.out.println("Child notifies about action complete.");
            this.notify();
        }
    }
}

public class InterCommunicationDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo3 td = new ThreadDemo3();
        td.start();
        synchronized (td) {
            System.out.println("Main waiting for td.");
            td.wait();
            System.out.println("Main thread gives notification.");
            System.out.println(td.sum);
        }
    }
}

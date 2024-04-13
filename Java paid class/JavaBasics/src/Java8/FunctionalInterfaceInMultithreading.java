package Java8;

class MyThread implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Job = "+i);
        }
    }
}

public class FunctionalInterfaceInMultithreading {
    public static void main(String[] args) {

        // Thread using interface method...........
//        MyThread myThread= new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();

        // Thread using lambda method.............
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Job = "+i);
            }
        });
        thread.start();
    }
}

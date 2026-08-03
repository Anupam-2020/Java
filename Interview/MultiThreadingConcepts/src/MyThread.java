public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 2000000000; i++) {

        }
        System.out.println("Task executed by : " +  Thread.currentThread().getName());
    }
}

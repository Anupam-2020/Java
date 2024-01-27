package Multithreading.C20_01_24;

class PrintMsg {
    public synchronized void  m1() { // applying synchronization to method will put the whole method in synchronization
        for (int i = 0; i < 5; i++) {
//            synchronized (this) { // to put specific codes in synchronization. This is called synchronization within block.
//                System.out.println("Executed by: "+Thread.currentThread().getName());
//                System.out.println("Hello Anupam");
//            }

            System.out.println("Executed by: "+Thread.currentThread().getName());
            System.out.println("Hello Anupam");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Bye Anupam");
        }
    }
}

class SyncDemo extends Thread {
    PrintMsg t1;
    SyncDemo(PrintMsg t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        t1.m1();
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        PrintMsg pm = new PrintMsg();
        SyncDemo sd = new SyncDemo(pm);
        SyncDemo sd1 = new SyncDemo(pm);
        sd.start();
        sd1.start();
    }
}

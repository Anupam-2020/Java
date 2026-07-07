public class Logger {
//    private static Logger instance;

    private static volatile Logger instance; // volatile keyword ensures that multiple threads handle the instance variable correctly when it is being initialized to the Singleton instance.
    // In double-checked locking, the volatile keyword ensures that the instance variable is read from main memory and not from a thread's local cache, which can lead to visibility issues in a multithreaded environment.

    private Logger() {

    }

//    public static Logger getInstance() { // this is not thread safe as if two threads call getInstance() at the same time, they may see instance == null and end up creating  separate objects.
//        if(instance == null) {
//            instance = new Logger();
//        }
//        return instance;
//    }

//    public static synchronized Logger getInstance() { // This is thread safe but inefficient. Even after object is created, threads need to wait.
//        if(instance == null) {
//            instance = new Logger();
//        }
//
//        return instance;
//    }

    public static Logger getInstance() {
        if(instance == null) {
            synchronized (Logger.class) {
                if(instance == null) {
                    instance = new Logger();
                }
            }
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("log: "+message);
    }
}
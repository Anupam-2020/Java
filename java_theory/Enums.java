enum Status { // enum class extends Enum....
    Running, Failed, Pending, Success;
}

public class Enums {
    public static void main(String[] args) {
        Status s = Status.Success;
        System.out.println(s.ordinal()); // ordinal gives the sequence of value in enum.....
        Status ss[] = Status.values(); // values() gives -> Status[]
        System.out.println(s.getClass().getSuperclass().getName());
        for(Status status : ss) {
            System.out.println(status+ " : "+status.ordinal());
        }

        switch(s) {
            case Running : System.out.println("App is running");
            case Failed : System.out.println("App is failed");
            case Pending : System.out.println("App is in pending state");
            default : System.out.println("Done");
        }
    }
}

package Constructor.Dependency;

public class Car {
    private Engine eng;

    public Car(Engine eng) {
        this.eng = eng;
    }

    public void drive() {
        int start = eng.start();
        if(start > 0) System.out.println("Engine started...");
        else System.out.println("Engine not started...");
    }
}

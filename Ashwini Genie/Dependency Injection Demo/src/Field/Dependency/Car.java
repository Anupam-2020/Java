package Field.Dependency;

public class Car {

    Engine eng;

    public void drive() {
        int start = eng.start();
        if(start > 0) System.out.println("Engine has started...");
    }
}

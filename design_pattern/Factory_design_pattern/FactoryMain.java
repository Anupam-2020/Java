package Factory_design_pattern;

public class FactoryMain {
    public static void main(String[] args) {

        // OS obj = new Android();
        // obj.spec();

        // In factory design pattern the user don't need to know about internal functions...
        OperatingSystemFactory osf = new OperatingSystemFactory();
        OS obj = osf.getInstance("davda");
        obj.spec();

    }
}
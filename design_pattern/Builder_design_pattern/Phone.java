package Builder_design_pattern;

public class Phone {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public Phone(String os, int ram, String processor, double screenSize, int battery) {
        super();
        this.os = os;
        this.battery = battery;
        this.processor = processor;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    // public String getData() {
    //     return "Phone => os= "+ os + ", ram = " + ram + " gb " + ", processor = " + processor + ", screenSize = " + screenSize + " inch " + ", battery  = " + battery + " mAh";
    // }

    @Override
    public String toString() {
        return "Phone => os= "+ os + ", ram = " + ram + " gb " + ", processor = " + processor + ", screenSize = " + screenSize + " inch " + ", battery  = " + battery + " mAh";
    }
}

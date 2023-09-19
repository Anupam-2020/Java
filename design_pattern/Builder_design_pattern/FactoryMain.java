package Builder_design_pattern;

public class FactoryMain {
    public static void main(String[] args) {
        
        // Phone obj = new Phone("IOS", 6, "A16 Bionic", 6.1, 3500);
        // System.out.println(obj);

        // In builder design pattern, the user don't need to know the parameters or sequence of parameters....
        PhoneBuilder ph = new PhoneBuilder();
        System.out.println(ph.setBattery(3000).setOS("Android").getPhone());
    }
}

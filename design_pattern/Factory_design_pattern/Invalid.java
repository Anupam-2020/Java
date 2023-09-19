package Factory_design_pattern;

public class Invalid implements OS {
    @Override
    public void spec() {
        System.out.println("Invalid OS");
    }
}

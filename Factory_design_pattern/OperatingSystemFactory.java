package Factory_design_pattern;

public class OperatingSystemFactory {
    public OS getInstance(String str) {
        return str.equals("open") ? new Android() : str.equals("closed") ? new IOS() : str.equals("windows") ?  new Windows() : new Invalid();
    }
}

package AbstractFactory;

public class ButtonFactory {
    public static Button getButton(String operatingSystem) {
        return switch (operatingSystem) {
            case "windows" -> new WindowsButton();
            case "mac" -> new MacButton();
            default -> null;
        };
    }
}

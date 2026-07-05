package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        button.click();
    }
}

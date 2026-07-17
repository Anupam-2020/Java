package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        new WindowsFactory().createButton().click();
        new MacFactory().createButton().click();
    }
}

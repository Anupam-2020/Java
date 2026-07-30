//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation(new ShortestRoute());
        navigation.executeNavigation("home", "office");

        navigation.setStrategy(new FastestRoute());
        navigation.executeNavigation("home", "office");
    }
}
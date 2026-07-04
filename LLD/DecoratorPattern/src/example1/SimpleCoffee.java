package example1;

public class SimpleCoffee implements Coffee {
    @Override
    public int cost() {
        return 50;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

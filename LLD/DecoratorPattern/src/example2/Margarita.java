package example2;

public class Margarita extends BasePizza {
    @Override
    public int cost() {
        return 100;
    }

    @Override
    public String description() {
        return "Margarita pizza with";
    }
}

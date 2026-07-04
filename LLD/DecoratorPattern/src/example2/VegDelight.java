package example2;

public class VegDelight extends BasePizza {
    @Override
    public int cost() {
        return 120;
    }

    @Override
    public String description() {
        return "Veg Delight Pizza with";
    }
}

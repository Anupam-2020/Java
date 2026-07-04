package example2;

public class FarmHouse extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }

    @Override
    public String description() {
        return "farmhouse pizza with";
    }
}

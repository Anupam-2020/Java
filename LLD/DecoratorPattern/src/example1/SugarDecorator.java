public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 10;
    }

    @Override
    public String description() {
        return coffee.description()+" + Sugar";
    }
}

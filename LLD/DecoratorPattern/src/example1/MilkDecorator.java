package example1;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 20;
    }

    @Override
    public String description() {
        return coffee.description()+" + Milk";
    }
}

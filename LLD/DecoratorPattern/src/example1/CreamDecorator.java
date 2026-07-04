public class CreamDecorator extends CoffeeDecorator {

    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 30;
    }

    @Override
    public String description() {
        return coffee.description()+" + Cream";
    }
}

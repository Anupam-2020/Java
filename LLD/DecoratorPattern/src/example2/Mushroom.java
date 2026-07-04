package example2;

public class Mushroom extends ToppingDecorator {

    BasePizza basePizza;

    public Mushroom(BasePizza pizza) {
        basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost()+15;
    }

    @Override
    public String description() {
        return basePizza.description()+" mushroom toppings";
    }
}

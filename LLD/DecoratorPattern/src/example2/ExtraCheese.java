package example2;

public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza) {
        basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost()+ 10;
    }

    @Override
    public String description() {
        return basePizza.description() + " extra cheese toppings";
    }
}

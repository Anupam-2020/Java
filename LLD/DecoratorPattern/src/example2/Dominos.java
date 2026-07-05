package example2;

public class Dominos {
    public static void main(String[] args) {
        BasePizza basePizza = new FarmHouse();

        basePizza = new ExtraCheese(basePizza);
        System.out.println(basePizza.cost());
        System.out.println(basePizza.description());
    }
}

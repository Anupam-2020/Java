import example1.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        example1.Coffee coffee = new example1.SimpleCoffee();
//        coffee = new example1.MilkDecorator(coffee);
//        coffee = new example1.SugarDecorator(coffee);
//        coffee = new example1.CreamDecorator(coffee);


        Coffee coffee = new MilkDecorator(new SugarDecorator(new CreamDecorator(new SimpleCoffee())));

        System.out.println(coffee.description());
        System.out.println(coffee.cost());
    }
}
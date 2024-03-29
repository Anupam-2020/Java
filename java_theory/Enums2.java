enum Laptop { // enum classes can't be extended...
    Macbook(200000), XPS(220000), Surface, Thinkpad(90000);  //  in enums we create object in the class itself....

    private int price;

    private Laptop() { // we used private constructor because here object is created inside class only...
        price = 500;
        System.out.println("in laptop (non-parameterized constructor)"+" : "+this.name());
    }

    private Laptop(int price) {
        this.price = price;
        System.out.println("in laptop (parameterized constructor) "+" : "+this.name());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Enums2 {
    public static void main(String[] args) {
        Laptop lap = Laptop.Macbook;
        System.out.println(lap.name()+" : "+lap.getPrice());

        // Laptop.Macbook.setPrice(40000);
        // for(Laptop lap : Laptop.values()) {
        //     System.out.println(lap.name() +" : "+lap.getPrice());
        // }
    }
}

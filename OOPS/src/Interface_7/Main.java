package Interface_7;

public class Main {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();
        p.pay();
        p.printReceipts();
        Payment.info();
        System.out.println(CreditCardPayment.count);


        ObjectClass obj = new ObjectClass("Anupam");
        System.out.println(obj);
    }
}

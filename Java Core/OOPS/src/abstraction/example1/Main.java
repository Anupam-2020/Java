package abstraction.example1;

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new UPIPayment());
        checkoutService.pay();

        CheckoutService checkoutService1 = new CheckoutService(new CardPayment());
        checkoutService1.pay();
    }
}

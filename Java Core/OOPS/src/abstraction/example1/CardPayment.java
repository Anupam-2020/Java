package abstraction.example1;

public class CardPayment extends PaymentProcessor {
    @Override
    public void pay(Double amount) {
        validating();
        processing();
        System.out.println("Paying through Card ₹ "+amount);
    }

    private void validating() {
        System.out.println("Validating card...");
    }

    private void processing() {
        System.out.println("Processing card payment...");
    }
}

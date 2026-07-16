package abstraction.example1;

public class CheckoutService {
    private final PaymentProcessor paymentProcessor;

    CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void pay() {
        paymentProcessor.pay(2000.0);
    }
}

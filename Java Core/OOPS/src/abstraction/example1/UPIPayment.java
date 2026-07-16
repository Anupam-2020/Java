package abstraction.example1;

public class UPIPayment extends PaymentProcessor {
    @Override
    public void pay(Double amount) {
        validating();
        processing();
        System.out.println("Paying through UPI ₹ "+ amount);
    }

    private void validating() {
        System.out.println("Validating UPI...");
    }

    private void processing() {
        System.out.println("Processing UPI Payment...");
    }
}

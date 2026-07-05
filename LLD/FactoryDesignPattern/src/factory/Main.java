package factory;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.getPayment("Upi");
        payment.pay(2200);
    }
}

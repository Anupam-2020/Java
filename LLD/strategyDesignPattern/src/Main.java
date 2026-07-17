public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new UpiPayment());
        paymentService.makePayment(400);

        PaymentService paymentService1 = new PaymentService(new CreditCardPayment());
        paymentService1.makePayment(1000);

        PaymentService paymentService2 = new PaymentService(new PaypalPayment());
        paymentService2.makePayment(200);
    }
}

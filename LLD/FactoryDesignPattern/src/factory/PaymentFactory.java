package factory;

public class PaymentFactory {

    public static Payment getPayment(String modeOfPayment) {
        return switch (modeOfPayment) {
            case "Card" -> new CardPayment();
            case "Upi" -> new UpiPayment();
            default -> null;
        };
    }
}

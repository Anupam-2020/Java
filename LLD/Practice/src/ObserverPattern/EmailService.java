package ObserverPattern;

public class EmailService implements  OrderObserver {
    @Override
    public void update(String orderId) {
        System.out.println("Email notification sent for order "+orderId);
    }
}

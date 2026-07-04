package Example1.better;

public class SmsService implements OrderObserver {
    @Override
    public void update(String orderId) {
        System.out.println("Sms sent for order: "+orderId);
    }
}

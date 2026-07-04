package better;

public class WhatsappService implements OrderObserver {
    @Override
    public void update(String orderId) {
        System.out.println("WhatsApp message sent for order: " + orderId);
    }
}

package Example1.bad;

public class OrderService {
    public void placeOrder(String orderId) {
        System.out.println("Order place: "+orderId);
        sendEmail(orderId);
        sendSms(orderId);
        sendWhatsApp(orderId);
        generateInvoice(orderId);
        updateInventory(orderId);
    }

    private void sendEmail(String orderId) {
        System.out.println("Email sent for order: " + orderId);
    }

    private void sendSms(String orderId) {
        System.out.println("SMS sent for order: " + orderId);
    }

    private void updateInventory(String orderId) {
        System.out.println("Inventory updated for order: " + orderId);
    }

    private void sendWhatsApp(String orderId) {
        System.out.println("WhatsApp message sent for order: " + orderId);
    }

    private void generateInvoice(String orderId) {
        System.out.println("Invoice generated for order: " + orderId);
    }
}

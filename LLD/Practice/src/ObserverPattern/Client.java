package ObserverPattern;

public class Client {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.addObserver(new EmailService());
        orderService.addObserver(new InventoryService());
        orderService.placeOrder("Anupam12");
    }
}

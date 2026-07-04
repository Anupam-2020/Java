import Example1.better.EmailService;
import Example1.better.OrderService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        EmailService emailService = new EmailService();
        String orderId = "123ID";
        orderService.addOrders(emailService);
        orderService.placeOrder(orderId);
        orderService.removeObserver(emailService);
        orderService.placeOrder(orderId);
    }
}
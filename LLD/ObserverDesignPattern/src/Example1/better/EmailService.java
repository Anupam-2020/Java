package Example1.better;

public class EmailService implements OrderObserver {

    @Override
    public void update(String orderId) {
        System.out.println("Email sent for order : "+orderId);
    }
}

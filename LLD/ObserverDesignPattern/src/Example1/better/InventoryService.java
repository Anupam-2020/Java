package better;

public class InventoryService implements OrderObserver {
    @Override
    public void update(String orderId) {
        System.out.println("Invoice generated for order: " + orderId);
    }
}

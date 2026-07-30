package ObserverPattern;

public class InventoryService implements  OrderObserver {
    @Override
    public void update(String orderId) {
        System.out.println("Inventory updated for order: "+orderId);
    }
}

package Example1.better;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    List<OrderObserver> observers = new ArrayList<>();

    public void addOrders(OrderObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void placeOrder(String orderId) {
        System.out.println("Order place: "+orderId);

        notifyObservers(orderId);
    }

    private void notifyObservers(String orderId) {
        for(OrderObserver observer: observers) {
            observer.update(orderId);
        }
    }
}

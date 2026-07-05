package factory;

public class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid by UPI: "+amount);
    }
}

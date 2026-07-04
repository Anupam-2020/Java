package OpenClosePrinciple.better;

public class CardPayment implements Payment {
    public void pay() {
        System.out.println("Paid using card");
    }
}

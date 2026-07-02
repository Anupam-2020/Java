package OpenClosePrinciple.bad;


//A class should be open for extension but closed for modification.

class PaymentService {

    public void pay(String type) {
        if (type.equals("CARD")) {
            System.out.println("Paid using card");
        } else if (type.equals("UPI")) {
            System.out.println("Paid using UPI");
        }
    }
}

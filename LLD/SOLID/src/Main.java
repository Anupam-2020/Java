
import OpenClosePrinciple.better.CardPayment;
import OpenClosePrinciple.better.NetBankingPayment;
import OpenClosePrinciple.better.PaymentService;
import OpenClosePrinciple.better.UpiPayment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment(new CardPayment()); // This will print "Paid using card"
        paymentService.makePayment(new UpiPayment()); // This will print "Paid using upi"
        paymentService.makePayment(new NetBankingPayment()); // This will print "Paid using net banking"
    }
}
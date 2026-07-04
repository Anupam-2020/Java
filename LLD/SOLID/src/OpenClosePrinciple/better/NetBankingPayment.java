package OpenClosePrinciple.better;

public class NetBankingPayment implements Payment {
    public void pay() {
        System.out.println("Paid using NetBanking");
    }
}

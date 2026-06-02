package Interface_7;

interface Payment {
    void pay();

    int amount = 0; // variables in interface are by default public, static and final.

    default void printReceipts() {
        System.out.println("Receipt printed");
    }

    static void info() {
        System.out.println("Payment interface");
    }
}

interface Gateway {
    void pay();

//    default void printReceipts() {
//        System.out.println("");
//    }
}

// Note: - Although interface supports multiple inheritance, still the default methods can't be inherited.
class CreditCardPayment implements Payment, Gateway {

    static int count;
    @Override
    public void pay() {
        System.out.println("Paid using credit card");
    }

    void getAmount() {
        System.out.println(amount);
    }
}
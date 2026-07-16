package encapsulation;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(12.3);
        System.out.println(account.getBalance());
    }
}

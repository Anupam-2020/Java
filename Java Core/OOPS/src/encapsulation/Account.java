package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Double> balance = new ArrayList<>();

    public List<Double> getBalance() {
       return List.copyOf(balance);
    }

    public void setBalance(Double balance) {
        this.balance.add(balance);
    }
}

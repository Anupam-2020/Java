package Example2.Observer;

import Example2.Observable.StockObservable;

public class EmailAlertObservableImpl implements NotificationAlertObserver {

    String email;
    StockObservable observable;

    public EmailAlertObservableImpl(String emailId, StockObservable observable) {
        this.observable = observable;
        this.email = emailId;
    }

    @Override
    public void update() {
        sendMail(email, "product is in stock hurry up!");
    }

    private void sendMail(String msg, String emailId) {
        System.out.println(msg+" "+emailId);
    }
}

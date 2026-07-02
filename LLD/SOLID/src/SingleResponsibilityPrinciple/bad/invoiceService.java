package SingleResponsibilityPrinciple.bad;

// A class should have only one reason to change. Here one class is managing 3 things(doing calculation, database work, and email sending).
class InvoiceService {

    public void calculateTotal() {
        // calculate invoice total
    }

    public void saveToDatabase() {
        // save invoice to DB
    }

    public void sendEmail() {
        // send invoice email
    }
}

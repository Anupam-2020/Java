package SingleResponsibilityPrinciple.better;

class InvoiceCalculator {
    public void calculateTotal() {
        System.out.println("Calculating invoice total");
    }
}

class InvoiceRepository {
    public void save() {
        System.out.println("Saving invoice to database");
    }
}

class EmailService {
    public void sendEmail() {
        System.out.println("Sending invoice email");
    }
}

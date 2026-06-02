package com.anupam.bankingapi.model;

public class TransactionRequest {

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount;

    public TransactionRequest() {}

    public TransactionRequest(double amount) {
        this.amount = amount;
    }
}

package com.anupam.bankingapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Account {

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    private Long accountNumber;

    @NotBlank(message = "Holder name is required")
    private String holderName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Account type is required")
    private String accountType;

    @Min(value = 0, message = "Balance cannot be negative")
    private double balance;

    public Account(Long accountNumber, String holderName, String email, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.email = email;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Account() {}


}

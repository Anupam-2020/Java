package com.anand.bankingManagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAccountRequest {

    @NotBlank(message = "Holder name is required")
    private String holderName;

    @NotNull
    @Min(value = 0, message = "Balance cannot be negative")
    private Double balance;

    public String getHolderName() {
        return holderName;
    }

    public Double getBalance() {
        return balance;
    }
}

package com.anupam.razorpay.common.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;


@Embeddable // Embeddable means this class can be embedded in another entity.
// For example, if you have an entity called Order, you can embed Money in it to represent the amount of the order.
public class Money {
    private int amountUnits;
    private String currency;

    public Money() {
    }

    private Money(int amountUnits, String currency) {
        this.amountUnits = amountUnits;
        this.currency = currency;
    }

    public Money of(int amountUnits, String currency) { // This method is used to create a new Money object with the given amount and currency.
        return new Money(amountUnits, currency);
    }

    public Money inr(int amountUnits) {
        return new Money(amountUnits, "INR");
    }

    public Money add(Money other) {
        if(!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add Money with different currencies");
        }
        return new Money(this.amountUnits + other.amountUnits, this.currency);
    }

    public Money subtract(Money other) {
        if(!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot subtract Money with different currencies");
        }
        return new Money(this.amountUnits - other.amountUnits, this.currency);
    }
}

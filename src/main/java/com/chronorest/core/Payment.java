package com.chronorest.core;

import jakarta.validation.constraints.NotNull;

public class Payment {
    @NotNull(message = "Total amount cannot be null")
    private final Double totalAmount;

    public Payment(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}

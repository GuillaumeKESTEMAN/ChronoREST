package com.chronorest.core;

import jakarta.validation.constraints.NotNull;

public class Payment {
    @NotNull(message = "Total amount cannot be null")
    private final double totalAmount;

    public Payment(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

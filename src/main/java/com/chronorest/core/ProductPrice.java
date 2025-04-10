package com.chronorest.core;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductPrice {
    @NotNull(message = "Product ID cannot be null")
    private final int productId;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be positive")
    private final double amount;

    public ProductPrice(int productId, double amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public double getAmount() {
        return amount;
    }
}
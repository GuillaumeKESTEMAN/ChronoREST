package com.chronorest.core;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class ProductPrice {
    @NotNull(message = "Product ID cannot be null")
    private final Integer productId;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", message = "Amount must be positive")
    private final Double amount;

    public ProductPrice(Integer productId, Double amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public Integer getProductId() {
        return productId;
    }

    public Double getAmount() {
        return amount;
    }
}
package com.chronorest.core;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductPrice {
    @NotNull(message = "Product ID cannot be null")
    private final Integer productId;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be positive")
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
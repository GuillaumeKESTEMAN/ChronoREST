package com.chronorest.core;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Stock {
    @NotNull(message = "Stock list cannot be null")
    @NotEmpty(message = "Stock list cannot be empty")
    private final List<ProductStock> stock;

    public Stock(List<ProductStock> stock) {
        this.stock = stock;
    }

    public List<ProductStock> getStock() {
        return stock;
    }
}

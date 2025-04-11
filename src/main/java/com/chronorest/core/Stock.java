package com.chronorest.core;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    @NotEmpty(message = "Stock list cannot be empty")
    private final List<ProductStock> stock = new ArrayList<>();

    public List<ProductStock> getStock() {
        return stock;
    }
}

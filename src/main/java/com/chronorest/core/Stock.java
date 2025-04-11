package com.chronorest.core;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    @NotNull(message = "Stock list cannot be null")
    private final List<ProductStock> stock = new ArrayList<>();

    public List<ProductStock> getStock() {
        return stock;
    }
}

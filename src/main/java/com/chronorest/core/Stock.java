package com.chronorest.core;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Stock {

    @NotNull
    @NotEmpty(message = "Stocks list cannot be empty")
    private final List<ProductStock> stocks;

    public List<ProductStock> getStocks() {
        return stocks;
    }

    public Stock(List<ProductStock> stocks) {
        this.stocks = stocks;
    }
}

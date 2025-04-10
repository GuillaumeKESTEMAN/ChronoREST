package com.chronorest.core;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Prices {
    @NotNull(message = "Prices list cannot be null")
    @NotEmpty(message = "Prices list cannot be empty")
    private final List<ProductPrice> prices;

    public Prices(List<ProductPrice> prices) {
        this.prices = prices;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }
}

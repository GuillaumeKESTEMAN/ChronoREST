package com.chronorest.core;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class Prices {
    @NotEmpty(message = "Prices list cannot be empty")
    private List<ProductPrice> prices;

    public Prices(List<ProductPrice> prices) {
        this.prices = prices;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }
}

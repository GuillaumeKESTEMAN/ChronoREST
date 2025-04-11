package com.chronorest.core;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PricesServiceTest {
    @Autowired
    private PricesService pricesService;
    @Autowired
    private StockService stockService;

    @Test
    @Transactional
    void getEmptyPrices() {
        Prices prices = this.pricesService.getPrices();

        Assertions.assertThat(prices.getPrices()).isEmpty();
    }

    @Test
    @Transactional
    void savePrices() {
        List<ProductStock> productStocks = new ArrayList<>();
        productStocks.add(new ProductStock(1, "Product A", 10, 10.0));
        this.stockService.saveStock(new Stock(productStocks));

        List<ProductPrice> productPrices = new ArrayList<>();
        productPrices.add(new ProductPrice(1, 100.0));

        Prices returnedPrices = this.pricesService.savePrices(new Prices(productPrices));
        Prices actualPrices = this.pricesService.getPrices();
        Stock productStock = this.stockService.getStock();

        Assertions.assertThat(returnedPrices.getPrices()).isNotEmpty();
        Assertions.assertThat(returnedPrices.getPrices().getFirst().getProductId()).isEqualTo(1);
        Assertions.assertThat(actualPrices.getPrices()).isNotEmpty();
        Assertions.assertThat(actualPrices.getPrices().getFirst().getProductId()).isEqualTo(1);
        Assertions.assertThat(productStock.getStock().getFirst().getPrice()).isEqualTo(100.0);
    }

    @Test
    @Transactional
    void savePricesWithNonExistentProduct() {
        List<ProductPrice> productPrices = new ArrayList<>();
        productPrices.add(new ProductPrice(999, 100.0));

        Assertions.assertThatThrownBy(() -> this.pricesService.savePrices(new Prices(productPrices)))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Product with the id '999' was not found");
    }

    @Test
    @Transactional
    void savePricesWithEmptyList() {
        List<ProductPrice> productPrices = new ArrayList<>();

        Prices returnedPrices = this.pricesService.savePrices(new Prices(productPrices));
        Prices actualPrices = this.pricesService.getPrices();

        Assertions.assertThat(returnedPrices.getPrices()).isEmpty();
        Assertions.assertThat(actualPrices.getPrices()).isEmpty();
    }
}

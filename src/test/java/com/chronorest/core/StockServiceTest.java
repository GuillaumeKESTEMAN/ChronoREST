package com.chronorest.core;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StockServiceTest {
    @Autowired
    private StockService stockService;

    @Test
    @Transactional
    void getEmptyStock() {
        Stock stock = this.stockService.getStock();
        Assertions.assertThat(stock.getStock()).isEmpty();
    }

    @Test
    @Transactional
    void saveStock() {
        List<ProductStock> productStocks = new ArrayList<>();
        productStocks.add(new ProductStock(1, "Product A", 10, 100.0));
        Stock stock = new Stock(productStocks);
        this.stockService.saveStock(stock);

        Stock actualStock = this.stockService.getStock();
        Assertions.assertThat(actualStock.getStock()).isNotEmpty();
        Assertions.assertThat(actualStock.getStock().getFirst().getProductName()).isEqualTo("Product A");
    }
}

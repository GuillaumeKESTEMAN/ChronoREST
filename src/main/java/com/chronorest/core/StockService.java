package com.chronorest.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final ProductStockRepository productStockRepository;

    @Autowired
    public StockService(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    public Stock getStock() {
        return new Stock(productStockRepository.findAll());
    }

    public Stock saveStock(Stock stock) {
        productStockRepository.saveAll(stock.getStock());
        return stock;
    }
}

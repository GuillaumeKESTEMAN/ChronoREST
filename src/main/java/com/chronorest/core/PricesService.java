package com.chronorest.core;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService {
    private final ProductStockRepository productStockRepository;

    @Autowired
    public PricesService(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    public Prices getPrices() {
        List<ProductStock> productStocks = productStockRepository.findAll();
        List<ProductPrice> productPrices = productStocks.stream()
                .map(productStock -> new ProductPrice(productStock.getProductId(), productStock.getPrice()))
                .toList();

        return new Prices(productPrices);
    }

    public Prices savePrices(Prices prices) {
        for (ProductPrice productPrice : prices.getPrices()) {
            ProductStock productStock = productStockRepository.findById(productPrice.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product with the id '" + productPrice.getProductId() + "' was not found"));
            productStock.setPrice(productPrice.getAmount());
            productStockRepository.save(productStock);
        }

        return prices;
    }
}

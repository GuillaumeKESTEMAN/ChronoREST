package com.chronorest.core;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store/stock")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping()
    public Stock getStock() {
        return stockService.getStock();
    }

    @PostMapping()
    public Stock saveStock(@RequestBody @Valid Stock stock) {
        return stockService.saveStock(stock);
    }
}

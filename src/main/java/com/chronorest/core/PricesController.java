package com.chronorest.core;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/store/prices")
public class PricesController {
    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping()
    public Prices getPrices() {
        return pricesService.getPrices();
    }

    @PostMapping()
    public Prices savePrices(@RequestBody @Valid Prices prices) {
        try {
            return pricesService.savePrices(prices);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while saving prices", e);
        }
    }
}

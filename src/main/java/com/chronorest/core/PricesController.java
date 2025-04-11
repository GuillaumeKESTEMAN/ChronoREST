package com.chronorest.core;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/store/prices")
public class PricesController {
    @GetMapping()
    public Prices getPrices() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping()
    public Prices savePrices(@RequestBody @Valid Prices prices) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }
}

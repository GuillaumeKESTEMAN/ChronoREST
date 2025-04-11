package com.chronorest.core;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/store/stock")
public class StockController {
    @GetMapping()
    public Stock getStock() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping()
    public Stock saveStock(@RequestBody @Valid Stock stock) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }
}

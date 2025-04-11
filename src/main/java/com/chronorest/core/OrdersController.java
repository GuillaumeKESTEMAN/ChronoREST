package com.chronorest.core;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/store/orders")
public class OrdersController {
    @PostMapping()
    public Order saveOrder(@RequestBody @Valid Order order) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping("/{orderId}/payments")
    public Order saveOrderPayments(@PathVariable String orderId, @RequestBody @Valid Order order) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }
}

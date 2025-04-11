package com.chronorest.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

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

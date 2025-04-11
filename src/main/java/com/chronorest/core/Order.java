package com.chronorest.core;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id")
    @NotEmpty(message = "Order items cannot be empty")
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

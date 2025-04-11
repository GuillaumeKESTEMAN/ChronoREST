package com.chronorest.core;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Order {
    @Id
    private Integer id;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id")
    @NotNull(message = "Items list cannot be null")
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

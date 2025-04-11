package com.chronorest.core;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class ProductStock {
    @Id
    private Integer productId;

    @NotBlank(message ="ProductName is is mandatory")
    private String productName;

    @Min(value = 0, message ="Quantity must be positive") @NotNull(message = "Quantity must not be null")
    private Integer quantity;

    @Min(value = 0, message="Price must be positive") @NotNull(message ="Price must not be null")
    private Double price;

    public ProductStock() {
    }

    public ProductStock(Integer productId, String productName, Integer quantity, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}

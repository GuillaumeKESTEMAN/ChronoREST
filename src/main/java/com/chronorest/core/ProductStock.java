package com.chronorest.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class ProductStock {

    @Id
    @GeneratedValue 
    private int productId;

    @NotBlank(message ="ProductName is is mandatory")
    private String productName;

    @Min(value = 0, message ="Quantity must be positive") @NotNull(message = "Quantity must not be null")
    private int quantity;

    @Min(value = 0, message="Price must be positive") @NotNull(message ="Price must not be null")
    private int price;

    public ProductStock() {
    }

    public int getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
    

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}

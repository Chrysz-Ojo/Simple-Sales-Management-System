package com.chrysz.simple.sale.management.system.dto;

import lombok.Data;

@Data
public class TransactionUpdateRequest {

    private int quantity;
    private double price;

    // Default constructor (required for JSON serialization)
//    public TransactionUpdateRequest() {}
//
//    // Constructor with fields
//    public TransactionUpdateRequest(int quantity, double price) {
//        this.quantity = quantity;
//        this.price = price;
//    }
//
//    // Getters and setters
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
}

package com.chrysz.simple.sale.management.system.dto.request;

import com.chrysz.simple.sale.management.system.model.Sales;
import com.chrysz.simple.sale.management.system.model.Transactions;
import lombok.Data;

import java.util.List;

@Data
public class CreateSaleRequest {
    private Sales sales;
    private List<Transactions> transactions;

    // Default constructor (required for JSON serialization)
//    public CreateSaleRequest() {}
//
//    // Constructor with fields
//    public CreateSaleRequest(Sales sales, List<Transactions> transactions) {
//        this.sales = sales;
//        this.transactions = transactions;
//    }
//
//    // Getters and setters
//    public Sales getSales() {
//        return sales;
//    }
//
//    public void setSales(Sales sales) {
//        this.sales = sales;
//    }
//
//    public List<Transactions> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<Transactions> transactions) {
//        this.transactions = transactions;
//    }
}

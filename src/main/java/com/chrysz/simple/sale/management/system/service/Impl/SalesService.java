package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.model.Sales;
import com.chrysz.simple.sale.management.system.model.Transactions;

import java.util.List;

public interface SalesService {
    List<Sales> getAllSales();

    Sales createSale(Sales sales, List<Transactions> transactions);
    void updateTransaction(Long saleId, Long transactionId, int quantity, double price);

    Sales updateSale(Long saleId, Sales saleDetails);
}




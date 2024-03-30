package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.exception.ResourceNotFoundException;
import com.chrysz.simple.sale.management.system.model.Sales;
import com.chrysz.simple.sale.management.system.model.Transactions;
import com.chrysz.simple.sale.management.system.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales createSale(Sales sales, List<Transactions> transactions) {
        sales.setCreationDate(new Date());

        for (Transactions transaction : transactions) {
            transaction.setSale(sales);
        }

        sales.setTransactions(transactions);
        double total = calculateTotal(transactions);
        sales.setTotal(total);
        return salesRepository.save(sales);

    }

    private double calculateTotal(List<Transactions> transactions) {
        double total = 0;
        for (Transactions transaction : transactions) {
            total += transaction.getQuantity() * transaction.getPrice();
        }
        return total;
    }




    @Override
    public Sales updateSale(Long saleId, Sales saleDetails) {
        Optional<Sales> optionalSale = salesRepository.findById(saleId);
        if (optionalSale.isPresent()) {
            Sales existingSale = optionalSale.get();

            // Update sale details
            existingSale.setClient(saleDetails.getClient());
            existingSale.setSeller(saleDetails.getSeller());
            existingSale.setCreationDate(saleDetails.getCreationDate());
            existingSale.setTotal(saleDetails.getTotal());

            // Save and return the updated sale
            return salesRepository.save(existingSale);
        } else {
            throw new ResourceNotFoundException("Sale not found with id: " + saleId);
        }
    }

    @Override
    public void updateTransaction(Long saleId, Long transactionId, int quantity, double price) {
        Optional<Sales> optionalSale = salesRepository.findById(saleId);
        if (optionalSale.isPresent()) {
            Sales sale = optionalSale.get();
            List<Transactions> transactions = sale.getTransactions();
            for (Transactions transaction : transactions) {
                if (transaction.getId().equals(transactionId)) {
                    // Update quantity and price of the transaction
                    transaction.setQuantity(quantity);
                    transaction.setPrice(price);
                    break; // Exit loop once transaction is found and updated
                }
            }
            // Save the updated sale
            salesRepository.save(sale);
        } else {
            throw new ResourceNotFoundException("Sale not found with id: " + saleId);
        }
    }
}



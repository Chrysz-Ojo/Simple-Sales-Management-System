package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.exception.ResourceNotFoundException;
import com.chrysz.simple.sale.management.system.model.Transactions;
import com.chrysz.simple.sale.management.system.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public Transactions createTransaction(Transactions transactions) {
        return transactionsRepository.save(transactions);
    }

    @Override
    public Transactions updateTransaction(Long transactionId, Transactions transactionDetails) {
        Optional<Transactions> optionalTransactions = transactionsRepository.findById(transactionId);
        if (optionalTransactions.isPresent()) {
            Transactions existingTransaction = optionalTransactions.get();
            existingTransaction.setQuantity(transactionDetails.getQuantity());
            existingTransaction.setPrice(transactionDetails.getPrice());
            return transactionsRepository.save(existingTransaction);

        }else {
            throw new ResourceNotFoundException("Transaction not found with id: " + transactionId);
        }
    }
}

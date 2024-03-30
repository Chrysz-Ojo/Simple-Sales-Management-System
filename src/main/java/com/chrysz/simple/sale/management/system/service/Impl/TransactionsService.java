package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.model.Transactions;

public interface TransactionsService {
    Transactions createTransaction(Transactions transactions);

    Transactions updateTransaction(Long transactionId, Transactions transactionDetails);
}

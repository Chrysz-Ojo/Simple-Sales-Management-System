package com.chrysz.simple.sale.management.system.repository;


import com.chrysz.simple.sale.management.system.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

}

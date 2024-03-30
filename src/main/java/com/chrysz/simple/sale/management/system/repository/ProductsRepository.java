package com.chrysz.simple.sale.management.system.repository;

import com.chrysz.simple.sale.management.system.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}

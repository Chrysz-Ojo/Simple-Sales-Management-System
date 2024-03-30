package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.model.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductsService {
    List<Products> getAllProducts();

    ResponseEntity<Products> createProducts(Products products);

    Products updateProducts(Long productId, Products productDetails);

    void deleteProduct(Long productId);

}

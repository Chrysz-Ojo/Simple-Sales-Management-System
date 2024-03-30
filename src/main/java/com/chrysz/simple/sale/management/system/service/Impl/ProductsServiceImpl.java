package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.exception.ResourceNotFoundException;
import com.chrysz.simple.sale.management.system.model.Products;
import com.chrysz.simple.sale.management.system.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{
        @Autowired
        private ProductsRepository productsRepository;

        public List<Products> getAllProducts() {
            return productsRepository.findAll();
        }
        @Override
        public ResponseEntity<Products> createProducts(Products products) {
            Products createdProduct = productsRepository.save(products);
            return ResponseEntity.ok(createdProduct);
        }

    @Override
    public Products updateProducts(Long productId, Products productsDetails) {
        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));

        product.setName(productsDetails.getName());
        product.setDescription(productsDetails.getDescription());
        product.setCategory(productsDetails.getCategory());
        product.setQuantity(productsDetails.getQuantity());
        product.setPrice(productsDetails.getPrice());
        return productsRepository.save(product);
    }


    @Override
    public void deleteProduct(Long productId) {
        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));

        productsRepository.delete(products);
    }
    }

package com.chrysz.simple.sale.management.system.controller;

import com.chrysz.simple.sale.management.system.model.Products;
import com.chrysz.simple.sale.management.system.service.Impl.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productsController {
        @Autowired
        private ProductsService productsService;

        @GetMapping
        public ResponseEntity<List<Products>> getAllProducts() {
                List<Products> products = productsService.getAllProducts();
            return ResponseEntity.ok(products);
        }

        @PostMapping()
        public ResponseEntity<Products> createProducts(@RequestBody Products products) {
                return productsService.createProducts(products);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Products> updateProducts(@PathVariable(value = "id") Long productId, @RequestBody Products productDetails) {
                Products updatedProduct = productsService.updateProducts(productId, productDetails);
                return ResponseEntity.ok(updatedProduct);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
                productsService.deleteProduct(productId);
                return ResponseEntity.ok().build();
        }
}

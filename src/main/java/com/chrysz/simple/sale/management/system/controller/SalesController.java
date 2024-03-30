package com.chrysz.simple.sale.management.system.controller;

import com.chrysz.simple.sale.management.system.dto.TransactionUpdateRequest;
import com.chrysz.simple.sale.management.system.dto.request.CreateSaleRequest;
import com.chrysz.simple.sale.management.system.model.Sales;
import com.chrysz.simple.sale.management.system.model.Transactions;
import com.chrysz.simple.sale.management.system.service.Impl.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

        @Autowired
        private SalesService salesService;

        @GetMapping
        public List<Sales> getAllSales() {
            return salesService.getAllSales();
        }



    @PostMapping
    public Sales createSale(@RequestBody CreateSaleRequest request) {
        return salesService.createSale(request.getSales(), request.getTransactions());
    }




    @PutMapping("/{saleId}")
    public Sales updateSale(@PathVariable Long saleId, @RequestBody Sales saleDetails) {
        return salesService.updateSale(saleId, saleDetails);
    }

    @PutMapping("/{saleId}/transactions/{transactionId}")
    public ResponseEntity<Void> updateTransaction(@PathVariable Long saleId, @PathVariable Long transactionId, @RequestBody TransactionUpdateRequest updateRequest) {
        salesService.updateTransaction(saleId, transactionId, updateRequest.getQuantity(), updateRequest.getPrice());
        return ResponseEntity.ok().build();
    }

}



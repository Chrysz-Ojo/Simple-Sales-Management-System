package com.chrysz.simple.sale.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Products products;

        private int quantity;

        private double price;

        @ManyToOne
        @JoinColumn(name = "sale_id")
        private Sales sale;
        
    }


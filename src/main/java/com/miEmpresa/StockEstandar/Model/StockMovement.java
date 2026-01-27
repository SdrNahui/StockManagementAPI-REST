package com.miEmpresa.StockEstandar.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeStock stockMovementTypeStock;
    private int amount;
    private LocalDateTime date;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public StockMovement(){

    }

    public Long getId() {
        return id;
    }

    public TypeStock getStockMovementType() {
        return stockMovementTypeStock;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public Product getProduct() {
        return product;
    }

    public void setStockMovementType(TypeStock stockMovementTypeStock) {
        this.stockMovementTypeStock = stockMovementTypeStock;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}


package com.miEmpresa.StockEstandar.Dto;

import com.miEmpresa.StockEstandar.Model.StockMovement;
import com.miEmpresa.StockEstandar.Model.TypeStock;

import java.time.LocalDateTime;

public class StockResponse {
    private Long id;
    private Long productId;
    private TypeStock stock;
    private int amount;
    private LocalDateTime date;
    private String reason;

    public StockResponse(StockMovement m){
        this.id = m.getId();
        this.productId = m.getProduct().getId();
        this.stock = m.getStockMovementType();
        this.amount = m.getAmount();
        this.date = m.getDate();
        this.reason = m.getReason();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public TypeStock getStock() {
        return stock;
    }

    public void setStock(TypeStock stock) {
        this.stock = stock;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

package com.miEmpresa.StockEstandar.Dto;

import com.miEmpresa.StockEstandar.Model.Product;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private int stockActual;
    private BigDecimal price;

    public ProductResponse(Product p){
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.stockActual = p.getStockActual();
        this.price = p.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStockActual() {
        return stockActual;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

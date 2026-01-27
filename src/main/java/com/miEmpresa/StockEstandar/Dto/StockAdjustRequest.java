package com.miEmpresa.StockEstandar.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StockAdjustRequest {
    private Long id;
    @Min(0)
    private int amount;
    @NotBlank
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

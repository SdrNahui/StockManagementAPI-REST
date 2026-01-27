package com.miEmpresa.StockEstandar.Exception;

public class ProductException extends RuntimeException {
    public ProductException(Long id) {
        super("No existe el producto con la id: " + id);
    }
}


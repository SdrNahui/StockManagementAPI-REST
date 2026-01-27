package com.miEmpresa.StockEstandar.Exception;

public class StockIsufficientException extends RuntimeException{
        public StockIsufficientException(Long id){
            super("El stock es insuficiente en el producto de la id: " + id);
        }
}

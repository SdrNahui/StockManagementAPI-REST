package com.miEmpresa.StockEstandar.Exception;

public class ProductsWithMovementException extends RuntimeException {
    public ProductsWithMovementException(Long id){
        super("No se puede eliminar el producto con el id " + id + " porque tiene movimientos asociados");
    }

}

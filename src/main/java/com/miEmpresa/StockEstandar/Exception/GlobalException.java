package com.miEmpresa.StockEstandar.Exception;

import com.miEmpresa.StockEstandar.Dto.ErrorByMe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorByMe> notFound(ProductException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorByMe(exception.getMessage()));
    }

    @ExceptionHandler(StockIsufficientException.class)
    public ResponseEntity<ErrorByMe> badRequest(StockIsufficientException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorByMe(exception.getMessage()));
    }

    @ExceptionHandler(ProductsWithMovementException.class)
    public ResponseEntity<ErrorByMe> conflict(ProductsWithMovementException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorByMe(exception.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorByMe> others(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorByMe(exception.getMessage()));
    }
}

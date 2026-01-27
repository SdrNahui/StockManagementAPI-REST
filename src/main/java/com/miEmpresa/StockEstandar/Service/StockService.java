package com.miEmpresa.StockEstandar.Service;

import com.miEmpresa.StockEstandar.Exception.ProductException;
import com.miEmpresa.StockEstandar.Exception.StockIsufficientException;
import com.miEmpresa.StockEstandar.Model.Product;
import com.miEmpresa.StockEstandar.Model.StockMovement;
import com.miEmpresa.StockEstandar.Model.TypeStock;
import com.miEmpresa.StockEstandar.Repository.ProductRepository;
import com.miEmpresa.StockEstandar.Repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    public StockService(ProductRepository productRepository, StockRepository stockRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    public List<StockMovement> getAllMovements(){
        return stockRepository.findAll();
    }

    public List<StockMovement> getMovementsById(Long productId){
        Product p1 = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(productId));
        return stockRepository.findByProduct(p1);
    }
    @Transactional
    public StockMovement addStock(Long id, int amount, String reason){
        Product p1 = productRepository.findById(id).orElseThrow(() -> new ProductException(id));
        p1.setStockActual(p1.getStockActual() + amount);
        productRepository.save(p1);
        return createMovement(p1, TypeStock.IN, amount, reason);
    }
    @Transactional
    public StockMovement removeStock(Long id, int amount, String reason){
        Product p1 = productRepository.findById(id).orElseThrow(() -> new ProductException(id));
        if(p1.getStockActual() < amount) {
            throw new StockIsufficientException(id);
        }
        p1.setStockActual(p1.getStockActual() - amount);
        productRepository.save(p1);
        return createMovement(p1, TypeStock.OUT, amount, reason);
    }
    @Transactional
    public StockMovement adjustStock(Long id, int amount, String reason){
        Product p1 = productRepository.findById(id).orElseThrow(() -> new ProductException(id));
        p1.setStockActual(amount);
        productRepository.save(p1);
        return createMovement(p1, TypeStock.ADJUST, amount, reason);
    }
    private StockMovement createMovement(Product p1, TypeStock typeStock, int amount, String reason){
        StockMovement m = new StockMovement();
        m.setProduct(p1);
        m.setStockMovementType(typeStock);
        m.setDate(LocalDateTime.now());
        m.setAmount(amount);
        m.setReason(reason);
        return stockRepository.save(m);
    }

}

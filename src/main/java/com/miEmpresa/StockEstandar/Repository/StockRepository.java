package com.miEmpresa.StockEstandar.Repository;

import com.miEmpresa.StockEstandar.Model.Product;
import com.miEmpresa.StockEstandar.Model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockMovement, Long> {
    List<StockMovement> findByProduct(Product product);
    boolean existsByProductId(Long productId);
}

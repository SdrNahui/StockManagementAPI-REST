package com.miEmpresa.StockEstandar.Repository;

import com.miEmpresa.StockEstandar.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

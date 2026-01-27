package com.miEmpresa.StockEstandar.Service;

import com.miEmpresa.StockEstandar.Exception.ProductsWithMovementException;
import com.miEmpresa.StockEstandar.Model.Product;
import com.miEmpresa.StockEstandar.Model.StockMovement;
import com.miEmpresa.StockEstandar.Model.TypeStock;
import com.miEmpresa.StockEstandar.Repository.ProductRepository;
import com.miEmpresa.StockEstandar.Repository.StockRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final StockRepository stockRepository ;
    public ProductService(ProductRepository productRepository, StockRepository stockRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    public Product createProduct(Product product){
        Product p1 =  productRepository.save(product);
        if(p1.getStockActual() > 0){
            StockMovement initial = new StockMovement();
            initial.setProduct(p1);
            initial.setStockMovementType(TypeStock.IN);
            initial.setDate(LocalDateTime.now());
            initial.setAmount(p1.getStockActual());
            initial.setReason("Stock inicial");
            stockRepository.save(initial);
        }
        return p1;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll() ;
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Optional<Product> updateProduct(Long id, Product productUpdate){
        return productRepository.findById(id).map(exist -> {
            exist.setName(productUpdate.getName());
            exist.setDescription(productUpdate.getDescription());
            exist.setPrice(productUpdate.getPrice());
            return productRepository.save(exist);
        });
    }

    public boolean deleteProduct(Long id){
        if(!productRepository.existsById(id)) {
            return false;
        }
        if(stockRepository.existsByProductId(id)){
            throw new ProductsWithMovementException(id);
        }
        productRepository.deleteById(id);
        return true;
    }
}

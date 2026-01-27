package com.miEmpresa.StockEstandar.Controller;

import com.miEmpresa.StockEstandar.Dto.ErrorByMe;
import com.miEmpresa.StockEstandar.Dto.ProductResponse;
import com.miEmpresa.StockEstandar.Model.Product;
import com.miEmpresa.StockEstandar.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(){
        List<ProductResponse> productList = productService.getAllProduct().stream().map(ProductResponse::new).toList();
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id){
        return productService.getProductById(id).map(ProductResponse::new).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody Product product){
        Product pSave = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductResponse(pSave));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product){
        return productService.updateProduct(id, product).map(ProductResponse::new).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorByMe> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

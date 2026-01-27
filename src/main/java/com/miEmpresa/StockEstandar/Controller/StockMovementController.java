package com.miEmpresa.StockEstandar.Controller;

import com.miEmpresa.StockEstandar.Dto.StockAdjustRequest;
import com.miEmpresa.StockEstandar.Dto.StockRequest;
import com.miEmpresa.StockEstandar.Dto.StockResponse;
import com.miEmpresa.StockEstandar.Model.StockMovement;
import com.miEmpresa.StockEstandar.Service.StockService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockMovementController {
    private final StockService stockService;

    public StockMovementController(StockService service) {
        this.stockService = service;
    }
    @GetMapping
    public ResponseEntity<List<StockResponse>> getAllMovements(){
        List<StockResponse> movementsList = stockService.getAllMovements().stream().map(StockResponse::new).toList();
        return ResponseEntity.ok(movementsList);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<StockResponse>> getMovementsByProduct(@PathVariable Long id){
        List<StockResponse> movementsList = stockService.getMovementsById(id).stream().map(StockResponse::new).toList();
        return ResponseEntity.ok(movementsList);
    }

    @PostMapping("/add")
    public ResponseEntity<StockResponse> addStock(@Valid @RequestBody StockRequest request){
        StockMovement sm = stockService.addStock(request.getId(), request.getAmount(), request.getReason());
        return ResponseEntity.status(HttpStatus.CREATED).body(new StockResponse(sm));
    }
    @PostMapping("/remove")
    public ResponseEntity<StockResponse> removeStock(@Valid @RequestBody StockRequest request){
        StockMovement sm = stockService.removeStock(request.getId(), request.getAmount(), request.getReason());
        return ResponseEntity.status(HttpStatus.CREATED).body(new StockResponse(sm));
    }
    @PostMapping("/adjust")
    public ResponseEntity<StockResponse> adjustStock(@Valid @RequestBody StockAdjustRequest request){
        StockMovement sm = stockService.adjustStock(request.getId(), request.getAmount(), request.getReason());
        return ResponseEntity.ok(new StockResponse(sm));
    }

}

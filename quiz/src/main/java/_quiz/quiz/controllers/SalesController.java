package _quiz.quiz.controllers;

import _quiz.quiz.entity.SaleEntity;
import _quiz.quiz.entity.SaleRequest;
import _quiz.quiz.entity.SaleTransactionEntity;
import _quiz.quiz.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<SaleEntity> getAllSales() {
        return saleService.getAllSales();
    }

    @PostMapping
    public SaleEntity createSale(@RequestBody SaleRequest saleRequest) {
        return saleService.createSale(saleRequest.getSale(), saleRequest.getTransactions());
    }


    @PutMapping("/{id}")
    public ResponseEntity<SaleEntity> updateSaleTransaction(@PathVariable Long id, @RequestBody List<SaleTransactionEntity> updatedTransactions) {
        SaleEntity updatedSale = saleService.updateSaleTransaction(id, updatedTransactions);
        return ResponseEntity.ok(updatedSale);
    }
}

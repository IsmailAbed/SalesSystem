package _quiz.quiz.services;

import _quiz.quiz.entity.SaleEntity;
import _quiz.quiz.entity.SaleTransactionEntity;
import _quiz.quiz.repository.SaleRepository;
import _quiz.quiz.repository.SaleTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleTransactionRepository saleTransactionRepository;

    public List<SaleEntity> getAllSales() {
        return saleRepository.findAll();
    }

    public SaleEntity createSale(SaleEntity sale, List<SaleTransactionEntity> transactions) {
        if (sale == null) {
            throw new RuntimeException("SaleEntity cannot be null");
        }

        // Calculate the total amount
        BigDecimal total = transactions.stream()
                .map(t -> t.getPrice().multiply(BigDecimal.valueOf(t.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setTotal(total);

        // Set up relationships
        sale.setTransactions(transactions);
        transactions.forEach(t -> t.setSale(sale));

        // Save the sale and transactions
        saleRepository.save(sale);
        saleTransactionRepository.saveAll(transactions);

        return sale;
    }


    public SaleEntity updateSaleTransaction(Long saleId, List<SaleTransactionEntity> updatedTransactions) {
        SaleEntity sale = saleRepository.findById(saleId).orElseThrow(() -> new RuntimeException("Sale not found"));

        // Update the transactions
        saleTransactionRepository.deleteAll(sale.getTransactions());
        updatedTransactions.forEach(t -> t.setSale(sale));
        saleTransactionRepository.saveAll(updatedTransactions);

        // Recalculate the total
        BigDecimal total = updatedTransactions.stream()
                .map(t -> t.getPrice().multiply(BigDecimal.valueOf(t.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setTotal(total);

        return saleRepository.save(sale);
    }
}

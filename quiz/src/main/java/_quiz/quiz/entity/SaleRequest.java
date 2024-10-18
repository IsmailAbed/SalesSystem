package _quiz.quiz.entity;

import java.util.List;

public class SaleRequest {
    private SaleEntity sale;
    private List<SaleTransactionEntity> transactions;

    // Getters and Setters
    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public List<SaleTransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<SaleTransactionEntity> transactions) {
        this.transactions = transactions;
    }
}

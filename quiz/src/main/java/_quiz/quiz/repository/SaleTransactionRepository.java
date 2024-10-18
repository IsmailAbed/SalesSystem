package _quiz.quiz.repository;

import _quiz.quiz.entity.SaleTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionRepository extends JpaRepository<SaleTransactionEntity, Long> {
}
package _quiz.quiz.repository;

import _quiz.quiz.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
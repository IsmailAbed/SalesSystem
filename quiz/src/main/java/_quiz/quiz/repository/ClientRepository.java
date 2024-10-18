package _quiz.quiz.repository;

import _quiz.quiz.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
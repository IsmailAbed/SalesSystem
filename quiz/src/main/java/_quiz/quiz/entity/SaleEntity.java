package _quiz.quiz.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    private String seller;
    private BigDecimal total;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleTransactionEntity> transactions;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }
}

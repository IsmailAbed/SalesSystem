package _quiz.quiz.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class SaleTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonIgnore
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private int quantity;
    private BigDecimal price;
}

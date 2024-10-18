package _quiz.quiz.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String mobile;


}

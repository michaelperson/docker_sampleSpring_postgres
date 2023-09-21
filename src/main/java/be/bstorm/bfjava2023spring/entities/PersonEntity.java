package be.bstorm.bfjava2023spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Person")
@Table(name = "person")
@Data
public class PersonEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String lastname;
    private String firstname;
}

package be.bstorm.bfjava2023spring.repositories;

import be.bstorm.bfjava2023spring.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    @Query(value = "SELECT p FROM Person p WHERE p.firstname = :firstname")
    Optional<PersonEntity> findByFirstname(@Param("firstname") String firstname);
}

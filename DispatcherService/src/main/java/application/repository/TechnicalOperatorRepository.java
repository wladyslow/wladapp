package application.repository;

import application.entities.TechnicalOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicalOperatorRepository extends JpaRepository<TechnicalOperator, Long> {

    Optional<TechnicalOperator> findByName(String name);
}

package application.repository;

import application.entities.TechnicalOperator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalOperatorRepository extends JpaRepository<TechnicalOperator, Long> {
}

package application.repository;

import application.entities.TechOperatorDeficiency;
import application.entities.TechnicalOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechOperatorDeficiencyRepository extends JpaRepository<TechOperatorDeficiency, Long> {

    List<TechOperatorDeficiency> findByTechnicalOperator(TechnicalOperator technicalOperator);
}

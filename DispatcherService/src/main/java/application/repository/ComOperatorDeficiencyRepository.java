package application.repository;

import application.entities.ComOperatorDeficiency;
import application.entities.CommercialOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComOperatorDeficiencyRepository extends JpaRepository<ComOperatorDeficiency, Long> {
    List<ComOperatorDeficiency> findByCommercialOperator(CommercialOperator commercialOperator);
}

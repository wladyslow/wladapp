package application.repository;

import application.entities.CommercialOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommercialOperatorRepository extends JpaRepository<CommercialOperator, Long> {

    Optional<CommercialOperator> findByName(String name);
}

package application.repository;

import application.entities.LoadingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadingOrderRepository extends JpaRepository<LoadingOrder, Long> {
}

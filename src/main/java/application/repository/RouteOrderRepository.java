package application.repository;

import application.entities.RouteOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteOrderRepository extends JpaRepository<RouteOrder, Long> {
}

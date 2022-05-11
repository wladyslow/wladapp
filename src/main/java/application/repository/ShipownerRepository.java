package application.repository;

import application.entities.Shipowner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipownerRepository extends JpaRepository<Shipowner, Long> {
}

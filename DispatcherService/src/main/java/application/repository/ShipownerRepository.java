package application.repository;

import application.entities.Shipowner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipownerRepository extends JpaRepository<Shipowner, Long> {

    Optional<Shipowner> findByName(String name);
}

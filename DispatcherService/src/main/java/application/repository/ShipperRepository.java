package application.repository;

import application.entities.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShipperRepository extends JpaRepository<Shipper, Long> {

    Optional<Shipper> findByName(String name);

    Optional<Shipper> findByRusFullName(String rusFullName);

    List<Shipper> findByeMail(String eMail);
}

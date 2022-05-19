package application.repository;

import application.dto.ShipperDto;
import application.entities.ShipperQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipperQuantityRepository extends JpaRepository<ShipperQuantity, Long> {

    List<ShipperQuantity> findByShipper(ShipperDto shipperDto);
}

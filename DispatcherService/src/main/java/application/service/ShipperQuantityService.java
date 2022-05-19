package application.service;

import application.dto.ShipperDto;
import application.dto.ShipperQuantityDto;

import java.util.List;
import java.util.Optional;

public interface ShipperQuantityService {

    Long createShipperQuantity(ShipperDto shipper, int quantity);

    List<ShipperQuantityDto> findAll();

    Optional<ShipperQuantityDto> findById(Long id);

    List<ShipperQuantityDto> findByShipper(ShipperDto shipper);

    void deleteById(Long id);

    ShipperQuantityDto save(ShipperQuantityDto shipperQuantityDto);

    ShipperQuantityDto update(ShipperQuantityDto shipperQuantityDto);

    void saveAll(List<ShipperQuantityDto> shipperQuantityDto);
}

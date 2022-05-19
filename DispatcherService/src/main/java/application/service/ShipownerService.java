package application.service;

import application.dto.*;

import java.util.List;
import java.util.Optional;

public interface ShipownerService {
    Long createShipowner(String name, String rusFullName, String email);

    List<ShipownerDto> findAll();

    Optional<ShipownerDto> findById(Long id);

    Optional<ShipownerDto> findByName(String name);

    void deleteById(Long id);
}

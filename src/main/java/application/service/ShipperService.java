package application.service;

import application.dto.ContractDto;
import application.dto.ShipperDto;

import java.util.List;
import java.util.Optional;

public interface ShipperService {

    Long createShipper(String name, String rusFullName, String eMail);

    List<ShipperDto> findAll();

    Optional<ShipperDto> findById(Long id);

    Optional<ShipperDto> findByName(String name);

    Optional<ShipperDto> findByRusFullName(String rusFullName);

    List<ShipperDto> findByEMail(String eMail);

    void deleteById(Long id);

    ShipperDto save(ShipperDto shipper);

    void update(Long id, ContractDto contract, String name, String rusFullName, String eMail);
}


package application.service;

import application.dto.CargoDto;
import application.entities.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoService {

    Long createCargo(String type);

    List<CargoDto> findAll();

    Optional<CargoDto> findById(Long id);

    Optional<Cargo> findCargoById(Long id);

    Optional<CargoDto> findByType(String type);

    void deleteById(Long id);

    CargoDto save(CargoDto cargoDto);

    CargoDto update(Long id, String type);
}

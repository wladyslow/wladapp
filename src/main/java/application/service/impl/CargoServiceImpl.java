package application.service.impl;

import application.dto.CargoDto;
import application.entities.Cargo;
import lombok.RequiredArgsConstructor;
import lombok.val;
import application.mapper.CargoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.CargoRepository;
import application.service.CargoService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;

    @Override
    @Transactional
    public Long createCargo(String type) {
        val cargoDto = new CargoDto(type);
        val cargo = cargoMapper.toEntity(cargoDto);
        cargoRepository.save(cargo);
        return cargo.getId();
    }

    @Override
    @Transactional
    public List<CargoDto> findAll() {
        return cargoMapper.toDtos(cargoRepository.findAll());
    }

    @Override
    @Transactional
    public Optional<CargoDto> findById(Long id) {
        return cargoMapper.toOptional(cargoRepository.findById(id));
    }

    @Override
    @Transactional
    public Optional<Cargo> findCargoById(Long id) {
        return cargoRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<CargoDto> findByType(String type) {
        return cargoMapper.toOptional(cargoRepository.findByType(type));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CargoDto save(CargoDto cargoDto) {
        if (!cargoRepository.existsById(cargoDto.getId())) {
            return cargoMapper.toDto(cargoRepository.save(cargoMapper.toEntity(cargoDto)));
        } else {
            return update(cargoDto.getId(), cargoDto.getType());
        }
    }

    @Override
    @Transactional
    public CargoDto update(Long id, String type) {
        cargoRepository.findById(id).ifPresent(cargo -> {
            cargo.setType(type);
        });
        return cargoMapper.toDto(cargoRepository.getById(id));
    }
}
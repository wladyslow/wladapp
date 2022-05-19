package application.service.impl;

import application.dto.ShipownerDto;
import application.mapper.ShipownerMapper;
import application.repository.ShipownerRepository;
import application.service.ShipownerService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipownerServiceImpl implements ShipownerService {

    private final ShipownerMapper shipownerMapper;
    private final ShipownerRepository shipownerRepository;

    @Override
    public Long createShipowner(String name, String rusFullName, String email) {
        val shipownerDto = new ShipownerDto(name, rusFullName, email);
        val shipowner = shipownerMapper.toEntity(shipownerDto);
        shipownerRepository.save(shipowner);
        return shipowner.getId();
    }

    @Override
    public List<ShipownerDto> findAll() {
        return shipownerMapper.toDtos(shipownerRepository.findAll());
    }

    @Override
    public Optional<ShipownerDto> findById(Long id) {
        return shipownerMapper.toOptional(shipownerRepository.findById(id));
    }

    @Override
    public Optional<ShipownerDto> findByName(String name) {
        return shipownerMapper.toOptional(shipownerRepository.findByName(name));
    }

    @Override
    public void deleteById(Long id) {
        shipownerRepository.deleteById(id);
    }
}

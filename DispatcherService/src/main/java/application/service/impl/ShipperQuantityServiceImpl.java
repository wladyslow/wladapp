package application.service.impl;

import application.dto.CargoDto;
import application.dto.ShipperDto;
import application.dto.ShipperQuantityDto;
import application.mapper.ShipperMapper;
import application.mapper.ShipperQuantityMapper;
import application.repository.ShipperQuantityRepository;
import application.service.ShipperQuantityService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipperQuantityServiceImpl implements ShipperQuantityService {

    private final ShipperQuantityRepository shipperQuantityRepository;
    private final ShipperQuantityMapper shipperQuantityMapper;
    private final ShipperMapper shipperMapper;

    @Override
    @Transactional
    public Long createShipperQuantity(ShipperDto shipper, int quantity) {
        val shipperQuantityDto = new ShipperQuantityDto(shipper, quantity);
        val shipperQuantity = shipperQuantityMapper.toEntity(shipperQuantityDto);
        shipperQuantityRepository.save(shipperQuantity);
        return shipperQuantity.getId();
    }

    @Override
    @Transactional
    public List<ShipperQuantityDto> findAll() {
        return shipperQuantityMapper.toDtos(shipperQuantityRepository.findAll());
    }

    @Override
    @Transactional
    public Optional<ShipperQuantityDto> findById(Long id) {
        return shipperQuantityMapper.toOptional(shipperQuantityRepository.findById(id));
    }

    @Override
    @Transactional
    public List<ShipperQuantityDto> findByShipper(ShipperDto shipper) {
        return shipperQuantityMapper.toDtos(shipperQuantityRepository.findByShipper(shipper));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        shipperQuantityRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveAll(List<ShipperQuantityDto> shipperQuantityList) {
        shipperQuantityList.stream().forEach(shipperQuantity ->save(shipperQuantity));
    }
    @Override
    @Transactional
    public ShipperQuantityDto save(ShipperQuantityDto shipperQuantity) {
        if (!shipperQuantityRepository.existsById(shipperQuantity.getId())) {
            return shipperQuantityMapper.toDto(shipperQuantityRepository.save(shipperQuantityMapper.toEntity(shipperQuantity)));
        } else {
            return update(shipperQuantity);
        }
    }

    @Override
    @Transactional
    public ShipperQuantityDto update(ShipperQuantityDto shipperQuantity) {
        shipperQuantityRepository.findById(shipperQuantity.getId()).ifPresent(shq -> {
            shq.setShipper(shipperMapper.toEntity(shipperQuantity.getShipper()));
            shq.setQuantity(shipperQuantity.getQuantity());
        });
        return shipperQuantityMapper.toDto(shipperQuantityRepository.getById(shipperQuantity.getId()));
    }
}

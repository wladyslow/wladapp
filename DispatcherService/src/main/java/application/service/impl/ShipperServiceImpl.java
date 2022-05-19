package application.service.impl;

import application.dto.ContractDto;
import application.dto.ShipperDto;
import application.mapper.ContractMapper;
import application.mapper.ShipperMapper;
import application.repository.ShipperRepository;
import application.service.ShipperService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipperServiceImpl implements ShipperService {

    private final ShipperRepository shipperRepository;
    private final ShipperMapper shipperMapper;
    private final ContractMapper contractMapper;

    @Override
    public Long createShipper(String name, String rusFullName, String eMail) {
        val shipperDto = new ShipperDto(name, rusFullName, eMail);
        val shipper = shipperMapper.toEntity(shipperDto);
        shipperRepository.save(shipper);
        return shipper.getId();
    }

    @Override
    public List<ShipperDto> findAll() {
        return shipperMapper.toDtos(shipperRepository.findAll());
    }

    @Override
    public Optional<ShipperDto> findById(Long id) {
        return shipperMapper.toOptional(shipperRepository.findById(id));
    }

    @Override
    public Optional<ShipperDto> findByName(String name) {
        return shipperMapper.toOptional(shipperRepository.findByName(name));
    }

    @Override
    public Optional<ShipperDto> findByRusFullName(String rusFullName) {
        return shipperMapper.toOptional(shipperRepository.findByRusFullName(rusFullName));
    }

    @Override
    public List<ShipperDto> findByEMail(String eMail) {
        return shipperMapper.toDtos(shipperRepository.findByeMail(eMail));
    }

    @Override
    public void deleteById(Long id) {
        shipperRepository.deleteById(id);
    }

    @Override
    public void update(Long id, ContractDto contract, String name, String rusFullName, String eMail) {
        shipperRepository.findById(id).ifPresent(shipper -> {
            shipper.setContract(contractMapper.toEntity(contract));
            shipper.setName(name);
            shipper.setRusFullName(rusFullName);
            shipper.setEMail(eMail);
        });
    }

    @Override
    @Transactional
    public ShipperDto save(ShipperDto shipper) {
        if (!shipperRepository.existsById(shipper.getId())) {
            return shipperMapper.toDto(shipperRepository.save(shipperMapper.toEntity(shipper)));
        } else {
            update(shipper.getId(), shipper.getContract(), shipper.getName(), shipper.getRusFullName(), shipper.getEMail());
            return shipper;
        }
    }
}


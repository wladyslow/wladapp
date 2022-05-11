package application.service;

import application.dto.ContractDto;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    Long createContract(String number);

    List<ContractDto> findAll();

    Optional<ContractDto> findById(Long id);

    Optional<ContractDto> findByNumber(String number);

    void deleteById(Long id);

    ContractDto save(ContractDto contractDto);

    void update(Long id, String number);
}


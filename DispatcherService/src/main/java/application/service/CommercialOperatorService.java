package application.service;

import application.dto.CommercialOperatorDto;

import java.util.List;
import java.util.Optional;

public interface CommercialOperatorService {

    Long createCommercialOperator(String name, String email);

    List<CommercialOperatorDto> findAll();

    Optional<CommercialOperatorDto> findById(Long id);

    Optional<CommercialOperatorDto> findByName(String name);

    void deleteById(Long id);
}


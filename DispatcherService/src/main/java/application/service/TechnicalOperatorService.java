package application.service;

import application.dto.TechnicalOperatorDto;

import java.util.List;
import java.util.Optional;

public interface TechnicalOperatorService {

    Long createTechnicalOperator(String name, String email);

    List<TechnicalOperatorDto> findAll();

    Optional<TechnicalOperatorDto> findById(Long id);

    Optional<TechnicalOperatorDto> findByName(String name);

    void deleteById(Long id);
}


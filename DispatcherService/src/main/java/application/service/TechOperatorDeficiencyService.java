package application.service;

import application.dto.TechOperatorDeficiencyDto;
import application.dto.TechnicalOperatorDto;

import java.util.List;
import java.util.Optional;

public interface TechOperatorDeficiencyService {

    List<TechOperatorDeficiencyDto> findAll();

    List<TechOperatorDeficiencyDto> findByTechnicalOperator(TechnicalOperatorDto technicalOperator);

    Optional<TechOperatorDeficiencyDto> findById(Long id);

    TechOperatorDeficiencyDto save(TechOperatorDeficiencyDto techOperatorDeficiencyDto);
}

package application.service;

import application.dto.ComOperatorDeficiencyDto;
import application.dto.CommercialOperatorDto;

import java.util.List;
import java.util.Optional;

public interface ComOperatorDeficiencyService {

    List<ComOperatorDeficiencyDto> findAll();

    List<ComOperatorDeficiencyDto> findByCommercialOperator(CommercialOperatorDto commercialOperatorDto);

    Optional<ComOperatorDeficiencyDto> findById(Long id);

    ComOperatorDeficiencyDto save(ComOperatorDeficiencyDto comOperatorDeficiencyDto);
}

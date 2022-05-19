package application.service.impl;

import application.dto.ComOperatorDeficiencyDto;
import application.dto.CommercialOperatorDto;
import application.mapper.ComOperatorDeficiencyMapper;
import application.mapper.CommercialOperatorMapper;
import application.repository.ComOperatorDeficiencyRepository;
import application.service.ComOperatorDeficiencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComOperatorDeficiencyServiceImpl implements ComOperatorDeficiencyService {

    private final ComOperatorDeficiencyRepository comOperatorDeficiencyRepository;
    private final ComOperatorDeficiencyMapper comOperatorDeficiencyMapper;
    private final CommercialOperatorMapper commercialOperatorMapper;

    @Override
    public List<ComOperatorDeficiencyDto> findAll() {
        return comOperatorDeficiencyMapper.toDtos(comOperatorDeficiencyRepository.findAll());
    }

    @Override
    public List<ComOperatorDeficiencyDto> findByCommercialOperator(CommercialOperatorDto commercialOperatorDto) {
        return comOperatorDeficiencyMapper.toDtos(comOperatorDeficiencyRepository.
                findByCommercialOperator(commercialOperatorMapper.toEntity(commercialOperatorDto)));
    }

    @Override
    public Optional<ComOperatorDeficiencyDto> findById(Long id) {
        return comOperatorDeficiencyMapper
                .toOptional(comOperatorDeficiencyRepository.findById(id));
    }

    @Override
    public ComOperatorDeficiencyDto save(ComOperatorDeficiencyDto comOperatorDeficiencyDto) {
        return comOperatorDeficiencyMapper.toDto(comOperatorDeficiencyRepository
                .save(comOperatorDeficiencyMapper.toEntity(comOperatorDeficiencyDto)));
    }
}

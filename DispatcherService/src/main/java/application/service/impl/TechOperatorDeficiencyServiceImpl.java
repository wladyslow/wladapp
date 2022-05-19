package application.service.impl;

import application.dto.TechOperatorDeficiencyDto;
import application.dto.TechnicalOperatorDto;
import application.mapper.TechOperatorDeficiencyMapper;
import application.mapper.TechnicalOperatorMapper;
import application.repository.TechOperatorDeficiencyRepository;
import application.service.TechOperatorDeficiencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechOperatorDeficiencyServiceImpl implements TechOperatorDeficiencyService {

    private final TechOperatorDeficiencyRepository techOperatorDeficiencyRepository;
    private final TechOperatorDeficiencyMapper techOperatorDeficiencyMapper;
    private final TechnicalOperatorMapper technicalOperatorMapper;

    @Override
    public List<TechOperatorDeficiencyDto> findAll() {
        return techOperatorDeficiencyMapper.toDtos(techOperatorDeficiencyRepository.findAll());
    }

    @Override
    public List<TechOperatorDeficiencyDto> findByTechnicalOperator(TechnicalOperatorDto technicalOperator) {
        return techOperatorDeficiencyMapper.toDtos(
                techOperatorDeficiencyRepository.findByTechnicalOperator(
                        technicalOperatorMapper.toEntity(technicalOperator)
                )
        );
    }

    @Override
    public Optional<TechOperatorDeficiencyDto> findById(Long id) {
        return techOperatorDeficiencyMapper.
                toOptional(techOperatorDeficiencyRepository.findById(id));
    }

    @Override
    public TechOperatorDeficiencyDto save(TechOperatorDeficiencyDto techOperatorDeficiencyDto) {
        return techOperatorDeficiencyMapper.toDto(techOperatorDeficiencyRepository.
                save(techOperatorDeficiencyMapper.toEntity(techOperatorDeficiencyDto)));
    }
}

package application.service.impl;

import application.dto.TechnicalOperatorDto;
import application.mapper.TechnicalOperatorMapper;
import application.repository.TechnicalOperatorRepository;
import application.service.TechnicalOperatorService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnicalOperatorServiceImpl implements TechnicalOperatorService {

    private final TechnicalOperatorMapper technicalOperatorMapper;
    private final TechnicalOperatorRepository technicalOperatorRepository;

    @Override
    public Long createTechnicalOperator(String name, String email) {
        val technicalOperatorDto = new TechnicalOperatorDto(name, email);
        val technicalOperator = technicalOperatorMapper.
                toEntity(technicalOperatorDto);
        technicalOperatorRepository.save(technicalOperator);
        return technicalOperator.getId();
    }


    @Override
    public List<TechnicalOperatorDto> findAll() {
        return technicalOperatorMapper.toDtos(technicalOperatorRepository.findAll());
    }

    @Override
    public Optional<TechnicalOperatorDto> findById(Long id) {
        return technicalOperatorMapper.toOptional(technicalOperatorRepository.findById(id));
    }

    @Override
    public Optional<TechnicalOperatorDto> findByName(String name) {
        return technicalOperatorMapper.toOptional(technicalOperatorRepository.findByName(name));
    }

    @Override
    public void deleteById(Long id) {
        technicalOperatorRepository.deleteById(id);
    }
}

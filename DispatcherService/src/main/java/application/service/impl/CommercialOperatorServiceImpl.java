package application.service.impl;

import application.dto.CommercialOperatorDto;
import application.mapper.CommercialOperatorMapper;
import application.repository.CommercialOperatorRepository;
import application.service.CommercialOperatorService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommercialOperatorServiceImpl implements CommercialOperatorService {

    private final CommercialOperatorMapper commercialOperatorMapper;
    private final CommercialOperatorRepository commercialOperatorRepository;

    @Override
    public Long createCommercialOperator(String name, String email) {
        val commercialOperatorDto = new CommercialOperatorDto(name, email);
        val commercialOperator = commercialOperatorMapper.
                toEntity(commercialOperatorDto);
        commercialOperatorRepository.save(commercialOperator);
        return commercialOperator.getId();
    }

    @Override
    public List<CommercialOperatorDto> findAll() {
        return commercialOperatorMapper.toDtos(commercialOperatorRepository.findAll());
    }

    @Override
    public Optional<CommercialOperatorDto> findById(Long id) {
        return commercialOperatorMapper.toOptional(commercialOperatorRepository.findById(id));
    }

    @Override
    public Optional<CommercialOperatorDto> findByName(String name) {
        return commercialOperatorMapper.toOptional(commercialOperatorRepository.findByName(name));
    }

    @Override
    public void deleteById(Long id) {
        commercialOperatorRepository.deleteById(id);
    }
}

package application.service.impl;

import application.dto.CaptainDto;
import application.dto.ContractDto;
import application.mapper.ContractMapper;
import application.repository.ContractRepository;
import application.service.ContractService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;


    @Override
    @Transactional
    public Long createContract(String number) {
        val contractDto = new ContractDto(number);
        val contract = contractMapper.toEntity(contractDto);
        contractRepository.save(contract);
        return contract.getId();
    }

    @Override
    @Transactional
    public List<ContractDto> findAll() {
        return contractMapper.toDtos(contractRepository.findAll());
    }

    @Override
    @Transactional
    public Optional<ContractDto> findById(Long id) {
        return contractMapper.toOptional(contractRepository.findById(id));
    }

    @Override
    @Transactional
    public Optional<ContractDto> findByNumber(String number) {
        return contractMapper.toOptional(contractRepository.findByNumber(number));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ContractDto save(ContractDto contractDto) {
        return contractMapper.toDto(contractRepository.save(contractMapper.toEntity(contractDto)));
    }

    @Override
    @Transactional
    public void update(Long id, String number) {
        contractRepository.findById(id).ifPresent(contract -> contract.setNumber(number));
    }
}

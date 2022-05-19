package application.service.impl;

import application.dto.AgentDto;
import application.dto.ContractDto;
import lombok.RequiredArgsConstructor;
import lombok.val;
import application.mapper.AgentMapper;
import application.mapper.ContractMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.AgentRepository;
import application.service.AgentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;
    private final ContractMapper contractMapper;

    @Override
    @Transactional
    public Long createAgent(ContractDto contract, String name, String rusFullName, String eMail) {
        val agentDto = new AgentDto(contract, name, rusFullName, eMail);
        val agent = agentMapper.toEntity(agentDto);
        agentRepository.save(agent);
        return agent.getId();
    }

    @Override
    @Transactional
    public List<AgentDto> findAll() {
        return agentMapper.toDtos(agentRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AgentDto> findById(Long id) {
        return agentMapper.toOptional(agentRepository.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AgentDto> findByName(String name) {
        return agentMapper.toOptional(agentRepository.findByName(name));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AgentDto> findByRusFullName(String rusFullName) {
        return agentMapper.toOptional(agentRepository.findByRusFullName(rusFullName));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        agentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, ContractDto contract, String name, String rusFullName, String eMail) {
        agentRepository.findById(id).ifPresent(agent -> {
            agent.setContract(contractMapper.toEntity(contract));
            agent.setName(name);
            agent.setRusFullName(rusFullName);
            agent.setEMail(eMail);
        });
    }
}

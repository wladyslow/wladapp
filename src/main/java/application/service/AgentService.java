package application.service;

import application.dto.AgentDto;
import application.dto.ContractDto;

import java.util.List;
import java.util.Optional;

public interface AgentService {

    Long createAgent(ContractDto contract, String name, String rusFullName, String eMail);

    List<AgentDto> findAll();

    Optional<AgentDto> findById(Long id);

    Optional<AgentDto> findByName(String name);

    Optional<AgentDto> findByRusFullName(String rusFullName);

    void deleteById(Long id);

    void update(Long id, ContractDto contract, String name, String rusFullName, String eMail);
}

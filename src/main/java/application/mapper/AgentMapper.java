package application.mapper;

import application.dto.AgentDto;
import application.entities.Agent;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AgentMapper {

    AgentDto toDto(Agent agentEntity);

    List<AgentDto> toDtos(List<Agent> agentEntityList);

    Agent toEntity(AgentDto agentDto);

    List<Agent> toEntities(List<AgentDto> agentDtoList);

    default Optional<AgentDto> toOptional(Optional<Agent> agentEntity) {
        return agentEntity.map(this::toDto);
    }
}

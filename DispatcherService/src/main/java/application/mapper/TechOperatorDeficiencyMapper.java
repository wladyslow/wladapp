package application.mapper;

import application.dto.TechOperatorDeficiencyDto;
import application.entities.TechOperatorDeficiency;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TechOperatorDeficiencyMapper {

    TechOperatorDeficiencyDto toDto(TechOperatorDeficiency entity);

    List<TechOperatorDeficiencyDto> toDtos(List<TechOperatorDeficiency> entityList);

    TechOperatorDeficiency toEntity(TechOperatorDeficiencyDto dto);

    List<TechOperatorDeficiency> toEntities(List<TechOperatorDeficiencyDto> dtoList);

    default Optional<TechOperatorDeficiencyDto> toOptional(Optional<TechOperatorDeficiency> entity) {
        return entity.map(this::toDto);
    }
}


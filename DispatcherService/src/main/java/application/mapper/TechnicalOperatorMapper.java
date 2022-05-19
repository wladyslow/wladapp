package application.mapper;

import application.dto.TechnicalOperatorDto;
import application.entities.TechnicalOperator;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TechnicalOperatorMapper {

    TechnicalOperatorDto toDto(TechnicalOperator entity);

    List<TechnicalOperatorDto> toDtos(List<TechnicalOperator> entityList);

    TechnicalOperator toEntity(TechnicalOperatorDto dto);

    List<TechnicalOperator> toEntities(List<TechnicalOperatorDto> dtoList);

    default Optional<TechnicalOperatorDto> toOptional(Optional<TechnicalOperator> entity) {
        return entity.map(this::toDto);
    }
}


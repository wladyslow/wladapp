package application.mapper;

import application.dto.CommercialOperatorDto;
import application.entities.CommercialOperator;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommercialOperatorMapper {

    CommercialOperatorDto toDto(CommercialOperator entity);

    List<CommercialOperatorDto> toDtos(List<CommercialOperator> entityList);

    CommercialOperator toEntity(CommercialOperatorDto dto);

    List<CommercialOperator> toEntities(List<CommercialOperatorDto> dtoList);

    default Optional<CommercialOperatorDto> toOptional(Optional<CommercialOperator> entity) {
        return entity.map(this::toDto);
    }
}


package application.mapper;

import application.dto.ComOperatorDeficiencyDto;
import application.entities.ComOperatorDeficiency;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ComOperatorDeficiencyMapper {

    ComOperatorDeficiencyDto toDto(ComOperatorDeficiency entity);

    List<ComOperatorDeficiencyDto> toDtos(List<ComOperatorDeficiency> entityList);

    ComOperatorDeficiency toEntity(ComOperatorDeficiencyDto dto);

    List<ComOperatorDeficiency> toEntities(List<ComOperatorDeficiencyDto> dtoList);

    default Optional<ComOperatorDeficiencyDto> toOptional(Optional<ComOperatorDeficiency> entity) {
        return entity.map(this::toDto);
    }
}


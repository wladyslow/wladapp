package application.mapper;

import application.dto.VesselToClearDto;
import application.entities.VesselToClear;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface VesselToClearMapper {

    VesselToClearDto toDto(VesselToClear entity);

    List<VesselToClearDto> toDtos(List<VesselToClear> entityList);

    VesselToClear toEntity(VesselToClearDto dto);

    List<VesselToClear> toEntities(List<VesselToClearDto> dtoList);

    default Optional<VesselToClearDto> toOptional(Optional<VesselToClear> entity) {
        return entity.map(this::toDto);
    }
}


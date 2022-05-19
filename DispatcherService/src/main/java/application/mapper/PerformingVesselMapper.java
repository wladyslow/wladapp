package application.mapper;

import application.dto.PerformingVesselDto;
import application.entities.PerformingVessel;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PerformingVesselMapper {

    PerformingVesselDto toDto(PerformingVessel entity);

    List<PerformingVesselDto> toDtos(List<PerformingVessel> entityList);

    PerformingVessel toEntity(PerformingVesselDto dto);

    List<PerformingVessel> toEntities(List<PerformingVesselDto> dtoList);

    default Optional<PerformingVesselDto> toOptional(Optional<PerformingVessel> entity) {
        return entity.map(this::toDto);
    }
}


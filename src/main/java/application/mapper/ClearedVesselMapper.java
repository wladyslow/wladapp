package application.mapper;

import application.dto.ClearedVesselDto;
import application.entities.ClearedVessel;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClearedVesselMapper {

    ClearedVesselDto toDto(ClearedVessel entity);

    List<ClearedVesselDto> toDtos(List<ClearedVessel> entityList);

    ClearedVessel toEntity(ClearedVesselDto dto);

    List<ClearedVessel> toEntities(List<ClearedVesselDto> dtoList);

    default Optional<ClearedVesselDto> toOptional(Optional<ClearedVessel> entity) {
        return entity.map(this::toDto);
    }
}


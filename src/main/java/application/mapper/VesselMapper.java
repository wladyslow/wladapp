package application.mapper;

import application.dto.VesselDto;
import application.entities.Vessel;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface VesselMapper {

    VesselDto toDto(Vessel vesselEntity);

    List<VesselDto> toDtos(List<Vessel> vesselEntityList);

    Vessel toEntity(VesselDto vesselDto);

    List<Vessel> toEntities(List<VesselDto> vesselDtoList);

    default Optional<VesselDto> toOptional(Optional<Vessel> vesselEntity) {
        return vesselEntity.map(this::toDto);
    }
}

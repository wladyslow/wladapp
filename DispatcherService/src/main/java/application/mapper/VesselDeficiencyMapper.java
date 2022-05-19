package application.mapper;

import application.dto.VesselDeficiencyDto;
import application.entities.VesselDeficiency;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface VesselDeficiencyMapper {

    VesselDeficiencyDto toDto(VesselDeficiency entity);

    List<VesselDeficiencyDto> toDtos(List<VesselDeficiency> entityList);

    VesselDeficiency toEntity(VesselDeficiencyDto dto);

    List<VesselDeficiency> toEntities(List<VesselDeficiencyDto> dtoList);

    default Optional<VesselDeficiencyDto> toOptional(Optional<VesselDeficiency> entity) {
        return entity.map(this::toDto);
    }
}


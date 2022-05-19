package application.mapper;

import application.dto.VesselWrapperDto;
import application.entities.VesselWrapper;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface VesselWrapperMapper {

    VesselWrapperDto toDto(VesselWrapper entity);

    List<VesselWrapperDto> toDtos(List<VesselWrapper> entityList);

    VesselWrapper toEntity(VesselWrapperDto dto);

    List<VesselWrapper> toEntities(List<VesselWrapperDto> dtoList);

    default Optional<VesselWrapperDto> toOptional(Optional<VesselWrapper> entity) {
        return entity.map(this::toDto);
    }
}


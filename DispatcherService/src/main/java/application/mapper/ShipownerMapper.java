package application.mapper;

import application.dto.ShipownerDto;
import application.entities.Shipowner;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ShipownerMapper {

    ShipownerDto toDto(Shipowner entity);

    List<ShipownerDto> toDtos(List<Shipowner> entityList);

    Shipowner toEntity(ShipownerDto dto);

    List<Shipowner> toEntities(List<ShipownerDto> dtoList);

    default Optional<ShipownerDto> toOptional(Optional<Shipowner> entity) {
        return entity.map(this::toDto);
    }
}

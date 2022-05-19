package application.mapper;

import application.dto.ShipperQuantityDto;
import application.entities.ShipperQuantity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ShipperQuantityMapper {

    ShipperQuantityDto toDto(ShipperQuantity shipperQuantityEntity);

    List<ShipperQuantityDto> toDtos(List<ShipperQuantity> shipperQuantityEntityList);

    ShipperQuantity toEntity(ShipperQuantityDto shipperQuantityDto);

    List<ShipperQuantity> toEntities(List<ShipperQuantityDto> shipperQuantityDtoList);

    default Optional<ShipperQuantityDto> toOptional(Optional<ShipperQuantity> shipperQuantityEntity) {
        return shipperQuantityEntity.map(this::toDto);
    }
}

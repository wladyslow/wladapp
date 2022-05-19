package application.mapper;

import application.dto.ShipperDto;
import application.entities.Shipper;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ShipperMapper {

    ShipperDto toDto(Shipper shipperEntity);

    List<ShipperDto> toDtos(List<Shipper> shipperEntityList);

    Shipper toEntity(ShipperDto shipperDto);

    List<Shipper> toEntities(List<ShipperDto> shipperDtoList);

    default Optional<ShipperDto> toOptional(Optional<Shipper> shipperEntity) {
        return shipperEntity.map(this::toDto);
    }
}


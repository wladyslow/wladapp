package application.mapper;

import application.dto.CargoDto;
import application.entities.Cargo;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CargoMapper {

    CargoDto toDto(Cargo cargoEntity);

    List<CargoDto> toDtos(List<Cargo> cargoEntityList);

    Cargo toEntity(CargoDto cargoDto);

    List<Cargo> toEntities(List<CargoDto> cargoDtoList);

    default Optional<CargoDto> toOptional(Optional<Cargo> cargoEntity) {
        return cargoEntity.map(this::toDto);
    }
}

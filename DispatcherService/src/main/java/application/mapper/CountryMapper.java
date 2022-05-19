package application.mapper;

import application.dto.CountryDto;
import application.entities.Country;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CountryMapper {

    CountryDto toDto(Country entity);

    List<CountryDto> toDtos(List<Country> entityList);

    Country toEntity(CountryDto dto);

    List<Country> toEntities(List<CountryDto> dtoList);

    default Optional<CountryDto> toOptional(Optional<Country> entity) {
        return entity.map(this::toDto);
    }
}


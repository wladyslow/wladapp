package application.mapper;

import application.dto.CaptainDto;
import application.entities.Captain;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CaptainMapper {

    CaptainDto toDto(Captain captainEntity);

    List<CaptainDto> toDtos(List<Captain> captainEntityList);

    Captain toEntity(CaptainDto captainDto);

    List<Captain> toEntities(List<CaptainDto> captainDtoList);

    default Optional<CaptainDto> toOptional(Optional<Captain> captainEntity) {
        return captainEntity.map(this::toDto);
    }
}

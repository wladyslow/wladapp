package application.mapper;

import application.dto.LoadingWindowDto;
import application.entities.LoadingWindow;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LoadingWindowMapper {

    LoadingWindowDto toDto(LoadingWindow loadingWindowEntity);

    List<LoadingWindowDto> toDtos(List<LoadingWindow> loadingWindowEntityList);

    LoadingWindow toEntity(LoadingWindowDto loadingWindowDto);

    List<LoadingWindow> toEntities(List<LoadingWindowDto> loadingWindowDtoList);

    default Optional<LoadingWindowDto> toOptional(Optional<LoadingWindow> loadingWindowEntity) {
        return loadingWindowEntity.map(this::toDto);
    }
}

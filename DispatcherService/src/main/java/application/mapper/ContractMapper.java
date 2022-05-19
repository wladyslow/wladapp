package application.mapper;

import application.dto.ContractDto;
import application.entities.Contract;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ContractMapper {

    ContractDto toDto(Contract contractEntity);

    List<ContractDto> toDtos(List<Contract> contractEntityList);

    Contract toEntity(ContractDto contractDto);

    List<Contract> toEntities(List<ContractDto> contractDtoList);

    default Optional<ContractDto> toOptional(Optional<Contract> contractEntity) {
        return contractEntity.map(this::toDto);
    }
}

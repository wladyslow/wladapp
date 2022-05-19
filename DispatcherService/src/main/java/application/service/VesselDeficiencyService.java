package application.service;

import application.dto.VesselDeficiencyDto;
import application.dto.VesselWrapperDto;

import java.util.List;
import java.util.Optional;

public interface VesselDeficiencyService {

    List<VesselDeficiencyDto> findAll();

    List<VesselDeficiencyDto> findByVesselWrapperOperator(VesselWrapperDto vesselWrapper);

    Optional<VesselDeficiencyDto> findById(Long id);

    VesselDeficiencyDto save(VesselDeficiencyDto vesselDeficiencyDto);
}

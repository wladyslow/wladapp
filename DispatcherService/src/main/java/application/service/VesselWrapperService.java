package application.service;

import application.dto.VesselDto;
import application.dto.VesselWrapperDto;

import java.util.List;
import java.util.Optional;

public interface VesselWrapperService {

    List<VesselWrapperDto> findAll();

    Optional<VesselWrapperDto> findByImo(int imo);

    Optional<VesselWrapperDto> findById(Long id);

    void deleteById(Long id);

    void update(Long id, String name,
    VesselDto currentVesselData);

    boolean existsByImo(int imo);

    VesselWrapperDto save(VesselWrapperDto vesselWrapperDto);
}

package app.service;

import app.dto.VesselClearanceDataDto;

import java.util.List;
import java.util.Optional;

public interface VettingService {

    List<VesselClearanceDataDto> findAllActiveRequests();

    List<VesselClearanceDataDto> findAllCheckedRequests();

    Optional<VesselClearanceDataDto> findByVesselToClearId(Long id);
}

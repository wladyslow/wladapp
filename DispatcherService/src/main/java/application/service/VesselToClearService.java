package application.service;

import application.dto.LoadingWindowDto;
import application.dto.VesselToClearDto;
import application.dto.VesselWrapperDto;
import application.enums.VesselToClearStatus;

import java.util.List;
import java.util.Optional;

public interface VesselToClearService {

    Long createVesselToClear(VesselWrapperDto vesselWrapper,
                             LoadingWindowDto loadingWindow, Long loadingWindowId, String technicalPart,
                             String vettingPart, boolean vettingStatus, VesselToClearStatus status,
                             String comments, boolean accepted);

    List<VesselToClearDto> findAll();

    List <VesselToClearDto> findByVesselToClearStatus(VesselToClearStatus vesselToClearStatus);

    List <VesselToClearDto> findByLoadingWindowId(Long loadingWindowId);

    Optional<VesselToClearDto> findById(Long id);

    void deleteById(Long id);

    void update(Long id, String technicalPart,
                String vettingPart, boolean vettingStatus, VesselToClearStatus status,
                String comments, boolean accepted);

    void updateFromVetting(Long id, String vettingPart, boolean vettingStatus);

    void updateFromDispatcher(Long id, String technicalPart, String comments,boolean accepted);
}

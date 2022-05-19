package application.service.impl;

import application.dto.LoadingWindowDto;
import application.dto.VesselToClearDto;
import application.dto.VesselWrapperDto;
import application.entities.VesselToClear;
import application.enums.VesselToClearStatus;
import application.mapper.LoadingWindowMapper;
import application.mapper.VesselToClearMapper;
import application.mapper.VesselWrapperMapper;
import application.repository.VesselToClearRepository;
import application.service.VesselToClearService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VesselToClearServiceImpl implements VesselToClearService {

    private final VesselToClearMapper vesselToClearMapper;
    private final VesselToClearRepository vesselToClearRepository;
    private final VesselWrapperMapper vesselWrapperMapper;
    private final LoadingWindowMapper loadingWindowMapper;


    @Override
    public Long createVesselToClear(VesselWrapperDto vesselWrapper, LoadingWindowDto loadingWindow,
                                    Long loadingWindowId,
                                    String technicalPart, String vettingPart, boolean vettingStatus,
                                    VesselToClearStatus status, String comments, boolean accepted) {
        return vesselToClearRepository.save(new VesselToClear(vesselWrapperMapper.toEntity(vesselWrapper),
                loadingWindowMapper.toEntity(loadingWindow), loadingWindowId,
                technicalPart, vettingPart, vettingStatus, status, comments, accepted)).getId();
    }

    @Override
    public List<VesselToClearDto> findAll() {
        return vesselToClearMapper.toDtos(vesselToClearRepository.findAll());
    }

    @Override
    public List<VesselToClearDto> findByVesselToClearStatus(VesselToClearStatus vesselToClearStatus) {
        return vesselToClearMapper.toDtos(vesselToClearRepository.findByStatus(vesselToClearStatus));
    }

    @Override
    public List<VesselToClearDto> findByLoadingWindowId(Long loadingWindowId) {
        return vesselToClearMapper.toDtos(vesselToClearRepository.findByLoadingWindowId(loadingWindowId));
    }

    @Override
    public Optional<VesselToClearDto> findById(Long id) {
        return vesselToClearMapper.toOptional(vesselToClearRepository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        vesselToClearRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String technicalPart, String vettingPart,
                       boolean vettingStatus, VesselToClearStatus status,
                       String comments, boolean accepted) {
        vesselToClearRepository.findById(id).ifPresent(v -> {
            v.setTechnicalPart(technicalPart);
            v.setVettingPart(vettingPart);
            v.setVettingStatus(vettingStatus);
            v.setStatus(status);
            v.setComments(comments);
            v.setAccepted(accepted);
            vesselToClearRepository.save(v);
        });
    }

    @Override
    public void updateFromVetting(Long id, String vettingPart, boolean vettingStatus) {
        vesselToClearRepository.findById(id).ifPresent(v -> {
            v.setVettingPart(vettingPart);
            v.setVettingStatus(vettingStatus);
            v.setStatus(VesselToClearStatus.CHECKED);
            vesselToClearRepository.save(v);
        });
    }

    @Override
    public void updateFromDispatcher(Long id, String technicalPart, String comments, boolean accepted) {
        vesselToClearRepository.findById(id).ifPresent(v -> {
            v.setTechnicalPart(technicalPart);
            v.setComments(comments);
            v.setAccepted(accepted);
            vesselToClearRepository.save(v);
        });
    }
}

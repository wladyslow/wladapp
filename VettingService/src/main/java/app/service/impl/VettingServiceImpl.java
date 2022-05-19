package app.service.impl;

import app.dto.VesselClearanceDataDto;
import app.feign.DispatcherService;
import app.service.VettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VettingServiceImpl implements VettingService {

    private final DispatcherService dispatcherService;

    @Override
    public List<VesselClearanceDataDto> findAllActiveRequests() {
        return dispatcherService.findActive();
    }

    @Override
    public List<VesselClearanceDataDto> findAllCheckedRequests() {
        return dispatcherService.findChecked();
    }

    @Override
    public Optional<VesselClearanceDataDto> findByVesselToClearId(Long id) {
        return dispatcherService.findById(id);
    }
}

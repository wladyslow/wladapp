package app.feign;

import app.dto.VesselClearanceDataDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DispatcherServiceFallback implements DispatcherService {


    @Override
    public List<VesselClearanceDataDto> findActive() {
        return new ArrayList<>();
    }

    @Override
    public List<VesselClearanceDataDto> findChecked() {
        return null;
    }

    @Override
    public Optional<VesselClearanceDataDto> findById(Long id) {
        return Optional.empty();
    }
}

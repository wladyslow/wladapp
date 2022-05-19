package app.feign;

import app.dto.VesselClearanceDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "DispatcherService", fallback = DispatcherServiceFallback.class)
public interface DispatcherService {

    @GetMapping("/api/clearance/active")
    List<VesselClearanceDataDto> findActive();

    @GetMapping("/api/clearance/checked")
    List<VesselClearanceDataDto> findChecked();

    @GetMapping("/api/clearance/active/{id}")
    Optional<VesselClearanceDataDto> findById(@PathVariable("id") Long vesselToClearId);
}

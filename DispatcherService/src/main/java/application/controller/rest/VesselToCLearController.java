package application.controller.rest;

import application.dto.*;
import application.enums.VesselToClearStatus;
import application.service.ComOperatorDeficiencyService;
import application.service.LoadingWindowService;
import application.service.TechOperatorDeficiencyService;
import application.service.VesselToClearService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/clearance")
public class VesselToCLearController {

    private final VesselToClearService vesselToClearService;
    private final LoadingWindowService loadingWindowService;
    private final TechOperatorDeficiencyService techOperatorDeficiencyService;
    private final ComOperatorDeficiencyService comOperatorDeficiencyService;

    @GetMapping("/active")
    public List<VesselClearanceDataDto> findActive() {
        List<VesselClearanceDataDto> vesselClearanceDataDtos = new ArrayList<>();
        List<VesselToClearDto> vesselToClearDtoList =
                vesselToClearService.findByVesselToClearStatus(VesselToClearStatus.ACTIVE);
        if (vesselToClearDtoList.size() != 0) {
            vesselToClearDtoList.stream().forEach(v -> {
                        vesselClearanceDataDtos.add(new VesselClearanceDataDto(
                                v.getId(),
                                v.getVesselWrapper().getName(),
                                v.getVesselWrapper().getImo(),
                                loadingWindowService.findById(v.getLoadingWindowId()).get().getInitDate(),
                                loadingWindowService.findById(v.getLoadingWindowId()).get().getLoadDate(),
                                v.getVesselWrapper().getVesselDeficiencies(),
                                techOperatorDeficiencyService.findByTechnicalOperator
                                        (v.getVesselWrapper().getCurrentVesselData().getTechnicalOperator()),
                                comOperatorDeficiencyService.findByCommercialOperator
                                        (v.getVesselWrapper().getCurrentVesselData().getCommercialOperator())
                        ));
                    }
            );
        }
        return vesselClearanceDataDtos;
    }

    @GetMapping("/checked")
    public List<VesselClearanceDataDto> findChecked() {
        List<VesselClearanceDataDto> vesselClearanceDataDtos = new ArrayList<>();
        List<VesselToClearDto> vesselToClearDtoList =
                vesselToClearService.findByVesselToClearStatus(VesselToClearStatus.CHECKED);
        if (vesselToClearDtoList.size() != 0) {
            vesselToClearDtoList.stream().forEach(v -> {
                        vesselClearanceDataDtos.add(new VesselClearanceDataDto(
                                v.getId(),
                                v.getVesselWrapper().getName(),
                                v.getVesselWrapper().getImo(),
                                loadingWindowService.findById(v.getLoadingWindowId()).get().getInitDate(),
                                loadingWindowService.findById(v.getLoadingWindowId()).get().getLoadDate(),
                                v.getVesselWrapper().getVesselDeficiencies(),
                                techOperatorDeficiencyService.findByTechnicalOperator
                                        (v.getVesselWrapper().getCurrentVesselData().getTechnicalOperator()),
                                comOperatorDeficiencyService.findByCommercialOperator
                                        (v.getVesselWrapper().getCurrentVesselData().getCommercialOperator())
                        ));
                    }
            );
        }
        return vesselClearanceDataDtos;
    }

    @GetMapping("/active/{id}")
    public Optional<VesselClearanceDataDto> findById(@PathVariable("id") Long vesselToClearId) {
        System.out.println(vesselToClearId);
        Optional<VesselToClearDto> vesselToClearDto = vesselToClearService.findById(vesselToClearId);
        if (vesselToClearDto.isEmpty()) {
            return Optional.empty();
        } else {
            val v = vesselToClearDto.get();
            return Optional.of(new VesselClearanceDataDto(
                    v.getId(),
                    v.getVesselWrapper().getName(),
                    v.getVesselWrapper().getImo(),
                    loadingWindowService.findById(v.getLoadingWindowId()).get().getInitDate(),
                    loadingWindowService.findById(v.getLoadingWindowId()).get().getLoadDate(),
                    v.getVesselWrapper().getVesselDeficiencies(),
                    techOperatorDeficiencyService.findByTechnicalOperator
                            (v.getVesselWrapper().getCurrentVesselData().getTechnicalOperator()),
                    comOperatorDeficiencyService.findByCommercialOperator(
                            v.getVesselWrapper().getCurrentVesselData().getCommercialOperator())));
        }
    }

    @PutMapping("status/update")
    public ResponseEntity<?> updateVesselToClearStatus(Long id, String vetting, boolean status) {
       vesselToClearService.updateFromVetting(id, vetting, status);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("dispatcher/update")
    public ResponseEntity<?> updateVesselToClearTechStatus(Long id, String technicalPart,
                                                           String comments,boolean accepted) {
        vesselToClearService.updateFromDispatcher(id, technicalPart, comments, accepted);
        return ResponseEntity.noContent().build();
    }
}



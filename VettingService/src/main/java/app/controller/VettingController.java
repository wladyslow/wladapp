package app.controller;

import app.dto.VesselClearanceDataDto;
import app.enums.DeficiencyStatus;
import app.service.VettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@Validated
@RequiredArgsConstructor
public class VettingController {

    private final VettingService vettingService;

    @GetMapping("/active")
    public String showActive() {
        return "activerequests";
    }

    @GetMapping("/active/{id}")
    public String showRequest(Model model, @PathVariable(value = "id") Long id) {
        vettingService.findByVesselToClearId(id).
                ifPresent(vsl -> model.addAttribute("request", vsl));
        List<DeficiencyStatus> statuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("vetStatuses", statuses);
        return "request";
    }

    @GetMapping("/reply")
    public String sendReply(VesselClearanceDataDto vesselClearanceDataDto) {
        return "redirect:/active";
    }
}

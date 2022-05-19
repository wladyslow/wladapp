package application.controller;

import application.dto.LoadingWindowDto;
import application.dto.VesselToClearDto;
import application.service.VesselToClearService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Validated
@RequiredArgsConstructor
public class VesselToClearPageController {

    private final VesselToClearService vesselToClearService;

    @GetMapping("/vesseltoclear/operate/{id}")
    public String operateVesselToClear(Model model, @PathVariable(value = "id") Long id) {
        VesselToClearDto vesselToClearDto = vesselToClearService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Request doesn't exist"));
        model.addAttribute("vesselToClearDto", vesselToClearDto);
        return "vesseltoclear/editvesselrequest";

    }
}

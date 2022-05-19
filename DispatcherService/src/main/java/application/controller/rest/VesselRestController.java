package application.controller.rest;

import application.dto.LoadingWindowDto;
import application.dto.VesselWrapperDto;
import application.service.VesselToClearService;
import application.service.VesselWrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/vessels")
public class VesselRestController {

    private final VesselWrapperService vesselWrapperService;

    @GetMapping("/all")
    public List<VesselWrapperDto> findAll() {
        return vesselWrapperService.findAll();
    }
}

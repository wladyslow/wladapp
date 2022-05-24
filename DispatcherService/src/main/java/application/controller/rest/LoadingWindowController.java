package application.controller.rest;

import application.dto.LoadingWindowDto;
import application.service.VesselToClearService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import application.service.LoadingWindowService;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/loadingwindows")
public class LoadingWindowController {

    private final LoadingWindowService loadingWindowService;
    private final VesselToClearService vesselToClearService;

    @GetMapping
    public List<LoadingWindowDto> find(@RequestParam String yearMonth) {
        return loadingWindowService.findByYearMonth(yearMonth);
    }

    @GetMapping("/all")
    public List<LoadingWindowDto> findAll() {
        return loadingWindowService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long lwId) {
        val loadingWindowDto = loadingWindowService.findById(lwId).get();
        loadingWindowDto.getVesselToClearList().stream()
                .forEach(v -> vesselToClearService.deleteById(v.getId()));
        loadingWindowService.deleteById(lwId);
        return ResponseEntity.noContent().build();
    }
}

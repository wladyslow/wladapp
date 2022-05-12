package application.controller.rest;

import application.dto.LoadingWindowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import application.service.LoadingWindowService;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/loadingwindows")
public class LoadingWindowController {

    private final LoadingWindowService loadingWindowService;

    @GetMapping
    public List<LoadingWindowDto> find(@RequestParam String yearMonth) {
        return loadingWindowService.findByYearMonth(yearMonth);
    }

    @GetMapping("/all")
    public List<LoadingWindowDto> findAll() {
        return loadingWindowService.findAll();
    }


}

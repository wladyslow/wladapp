package application.controller.rest;

import application.dto.LoadingWindowDto;
import application.entities.LoadingWindow;
import application.mapper.LoadingWindowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import application.service.LoadingWindowService;

import java.time.YearMonth;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/loadingwindows")
public class LoadingWindowController {

    private final LoadingWindowService loadingWindowService;
    private final LoadingWindowMapper loadingWindowMapper;

    @GetMapping
    public List<LoadingWindowDto> find(@RequestParam String yearMonth) {

        String[] monthYearArray = yearMonth.split("-");
        YearMonth pageYearMonth = YearMonth.of(Integer.parseInt(monthYearArray[0]), Integer.parseInt(monthYearArray[1]));
        System.out.println(yearMonth);
        System.out.println(loadingWindowService.findByYearMonth(yearMonth));
        return loadingWindowService.findByYearMonth(yearMonth);
        //return loadingWindowMapper.toDtos(loadingWindowService.findByYearMonth(pageYearMonth));
    }

    @GetMapping("/all")
    public List<LoadingWindowDto> findAll() {
        return loadingWindowService.findAll();
        //return loadingWindowMapper.toDtos(loadingWindowService.findAll());
    }


}

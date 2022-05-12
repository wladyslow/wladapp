package application.controller;

import application.dto.*;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import application.service.CargoService;
import application.service.ShipperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import application.service.LoadingWindowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Validated
@RequiredArgsConstructor
public class LoadingWindowPageController {

    private final LoadingWindowService loadingWindowService;
    private final ShipperService shipperService;
    private final CargoService cargoService;

    @GetMapping("/loadwindows")
    public String index() {
        return "lw/loadingwindows";
    }

    @GetMapping("/loadwindows/add")
    public String addLoadingWindow(Model model) {
        LoadingWindowDto loadingWindowDto = new LoadingWindowDto();
        List<ShipperDto> shippers = shipperService.findAll();
        List<CargoDto> cargoDtos = cargoService.findAll();
        List<LoadingWindowStatus> loadingWindowStatusList =
                new ArrayList<LoadingWindowStatus>(Arrays.asList(LoadingWindowStatus.values()));
        List<LoadingWindowType> loadingWindowTypeList =
                new ArrayList<LoadingWindowType>(Arrays.asList(LoadingWindowType.values()));
        model.addAttribute("loadingWindow", loadingWindowDto);
        model.addAttribute("allShipperDtoList", shippers);
        model.addAttribute("cargos", cargoDtos);
        model.addAttribute("statuses", loadingWindowStatusList);
        model.addAttribute("loadingWindowTypes", loadingWindowTypeList);
        return "lw/loadingwindow";
    }

    @GetMapping("/loadwindows/edit/{id}")
    public String showCurrentLoadingWindow(Model model, @PathVariable(value = "id") Long id) {
        LoadingWindowDto loadingWindowDto = loadingWindowService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loading window doesn't exist"));
        List<ShipperDto> shippers = shipperService.findAll();
        List<CargoDto> cargoDtos = cargoService.findAll();
        List<LoadingWindowStatus> loadingWindowStatusList =
                new ArrayList<LoadingWindowStatus>(Arrays.asList(LoadingWindowStatus.values()));
        List<LoadingWindowType> loadingWindowTypeList =
                new ArrayList<LoadingWindowType>(Arrays.asList(LoadingWindowType.values()));
        model.addAttribute("loadingWindow", loadingWindowDto);
        model.addAttribute("allShipperDtoList", shippers);
        model.addAttribute("cargos", cargoDtos);
        model.addAttribute("statuses", loadingWindowStatusList);
        model.addAttribute("loadingWindowTypes", loadingWindowTypeList);
        return "lw/loadingwindow";
    }

    @PostMapping("/loadwindows/save")
    public String saveLoadingWindow(LoadingWindowDto loadingWindowDto) {
        CargoDto cargoFromSting = cargoService.findById(Long.
                parseLong(loadingWindowDto.getCargo().getType())).get();
        ShipperDto shipperFromString = shipperService.findById(Long.
                parseLong(loadingWindowDto.getShipper().getName())).get();
        loadingWindowDto.setCargo(cargoFromSting);
        loadingWindowDto.setShipper(shipperFromString);
        loadingWindowService.save(loadingWindowDto);
        return "redirect:/loadwindows";
    }

    @GetMapping("/loadwindows/operate/{id}")
    public String operateLoadingWindow(Model model, @PathVariable(value = "id") Long id) {
        LoadingWindowDto loadingWindowDto = loadingWindowService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loading window doesn't exist"));
        List<LoadingWindowStatus> loadingWindowStatusList =
                new ArrayList<LoadingWindowStatus>(Arrays.asList(LoadingWindowStatus.values()));
        List<LoadingWindowType> loadingWindowTypeList =
                new ArrayList<LoadingWindowType>(Arrays.asList(LoadingWindowType.values()));
        model.addAttribute("loadingWindow", loadingWindowDto);
        model.addAttribute("statuses", loadingWindowStatusList);
        model.addAttribute("loadingWindowTypes", loadingWindowTypeList);
        return "lw/lwOperator";
    }

    @PostMapping("/loadwindows/update")
    public String updateLoadingWindow(LoadingWindowDto loadingWindowDto) {
        loadingWindowService.update(loadingWindowDto.getId(), loadingWindowDto.getType(),
                loadingWindowDto.getStatus(), loadingWindowDto.getVesselToClearList(),
                loadingWindowDto.getClearedVesselList());
        return "redirect:/loadwindows";
    }
}
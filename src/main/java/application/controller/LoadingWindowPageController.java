package application.controller;

import application.dto.CargoDto;
import application.dto.LoadingWindowDto;
import application.dto.ShipperDto;
import application.dto.ShipperQuantityDto;
import application.service.CargoService;
import application.service.ShipperQuantityService;
import application.service.ShipperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import application.service.LoadingWindowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Validated
@RequiredArgsConstructor
public class LoadingWindowPageController {

    private final LoadingWindowService loadingWindowService;
    private final ShipperService shipperService;
    private final CargoService cargoService;
    private final ShipperQuantityService shipperQuantityService;

    @GetMapping("/loadwindows")
    public String index() {
        return "lw/loadingwindows";
    }

    @GetMapping("/loadwindows/add")
    public String addLoadingWindow(Model model) {
        LoadingWindowDto loadingWindowDto = new LoadingWindowDto();
        List<ShipperDto> shippers = shipperService.findAll();
        List<ShipperQuantityDto> shipperQuantityDtos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            shipperQuantityDtos.add(new ShipperQuantityDto());
        }
        loadingWindowDto.setShipperQuantityList(shipperQuantityDtos);
        System.out.println(shipperQuantityDtos.size());
        List<CargoDto> cargoDtos = cargoService.findAll();
        model.addAttribute("loadingWindow", loadingWindowDto);
        model.addAttribute("allShipperDtoList", shippers);
        model.addAttribute("blankShipperQuantities", shipperQuantityDtos);
        model.addAttribute("cargos", cargoDtos);
        return "lw/loadingwindow";
    }

    @GetMapping("/loadwindows/edit/{id}")
    public String showCurrentLoadingWindow(Model model, @PathVariable(value = "id") Long id) {
        LoadingWindowDto loadingWindowDto = loadingWindowService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loading window doesn't exist"));
        model.addAttribute("loadingWindow", loadingWindowDto);
        return "lw/loadingwindow";
    }

    @PostMapping("/loadwindows/save")
    public String saveLoadingWindow(LoadingWindowDto loadingWindowDto) {
        List<ShipperQuantityDto> notEmptyList = new ArrayList<>();
        loadingWindowDto.getShipperQuantityList().stream().forEach(
                sh -> {
                    if (!sh.getShipper().equals(null)) {
                        notEmptyList.add(sh);
                    }
                }
        );
        shipperQuantityService.saveAll(notEmptyList);
        loadingWindowDto.setShipperQuantityList(notEmptyList);
        loadingWindowService.save(loadingWindowDto);
        return "redirect:/loadwindows";
    }
}

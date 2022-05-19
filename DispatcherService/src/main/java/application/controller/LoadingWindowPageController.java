package application.controller;

import application.dto.*;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import application.enums.VesselToClearStatus;
import application.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    private final VesselWrapperService vesselWrapperService;
    private final VesselToClearService vesselToClearService;

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/loadwindows")
    public String showLoadingWindows() {
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
                new ArrayList<>(Arrays.asList(LoadingWindowStatus.values()));
        List<LoadingWindowType> loadingWindowTypeList =
                new ArrayList<>(Arrays.asList(LoadingWindowType.values()));
        List<VesselWrapperDto> vesselWrapperDtoList = vesselWrapperService.findAll();
        if (loadingWindowDto.getVesselToClearList().size() == 0) {
            List<VesselToClearDto> vesselToClearDtoList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                vesselToClearDtoList.add(new VesselToClearDto());
            }
            loadingWindowDto.setVesselToClearList(vesselToClearDtoList);
        } else {
            int number = 10 - loadingWindowDto.getVesselToClearList().size();
            for (int i =0; i<number; i++){
                loadingWindowDto.getVesselToClearList().add(new VesselToClearDto());
            }
        }
        model.addAttribute("loadingWindow", loadingWindowDto);
        model.addAttribute("statuses", loadingWindowStatusList);
        model.addAttribute("loadingWindowTypes", loadingWindowTypeList);
        model.addAttribute("allVesselWrapperDtoList", vesselWrapperDtoList);
        return "lw/lwOperator";
    }

    @PostMapping("/loadwindows/update")
    public String updateLoadingWindow(LoadingWindowDto loadingWindowDto) {
        loadingWindowDto.getVesselToClearList().forEach(v -> {
            if (!v.getComments().equals(null)) {
                v.setVesselWrapper(vesselWrapperService.findById(Long.parseLong(v.getComments())).get());
                v.setLoadingWindowId(loadingWindowDto.getId());
                v.setComments("");
                v.setStatus(VesselToClearStatus.ACTIVE);
            }
        });
        loadingWindowDto.getVesselToClearList().removeIf(v -> v.equals(null));
        loadingWindowDto.getVesselToClearList().forEach(v ->
                vesselToClearService.createVesselToClear(v.getVesselWrapper(), loadingWindowDto, loadingWindowDto.getId(),
                        v.getTechnicalPart(), v.getVettingPart(),
                        v.isVettingStatus(), v.getStatus(), v.getComments(),
                        v.isAccepted()));
        loadingWindowService.update(loadingWindowDto.getId(), loadingWindowDto.getType(),
                loadingWindowDto.getStatus(), loadingWindowDto.getVesselToClearList(),
                loadingWindowDto.getClearedVesselList());
        return "redirect:/loadwindows";
    }
}
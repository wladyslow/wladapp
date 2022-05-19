package application.controller;

import application.dto.*;
import application.enums.IceClass;
import application.service.*;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Validated
@RequiredArgsConstructor
public class VesselPageController {

    private final VesselWrapperService vesselWrapperService;
    private final VesselService vesselService;
    private final ShipownerService shipownerService;
    private final CommercialOperatorService commercialOperatorService;
    private final TechnicalOperatorService technicalOperatorService;
    private final CountryService countryService;


    @GetMapping("/vessels")
    public String showVesselsList() {
        return "vessel/vessels";
    }

    @GetMapping("/vessels/add")
    public String addVessel(Model model) {
        VesselDto vesselDto = new VesselDto();
        List<ShipownerDto> shipowners = shipownerService.findAll();
        List<CountryDto> countries = countryService.findAll();
        List<CommercialOperatorDto> commercialOperators =
                commercialOperatorService.findAll();
        List<TechnicalOperatorDto> technicalOperators =
                technicalOperatorService.findAll();
        List<IceClass> iceClasses =
                new ArrayList<>(Arrays.asList(IceClass.values()));
        model.addAttribute("vessel", vesselDto);
        model.addAttribute("shipowners", shipowners);
        model.addAttribute("countries", countries);
        model.addAttribute("commercialOperators", commercialOperators);
        model.addAttribute("technicalOperators", technicalOperators);
        model.addAttribute("iceClasses", iceClasses);
        return "vessel/vessel";
    }

    @GetMapping("/vessels/edit/{id}")
    public String showCurrentVessel(Model model, @PathVariable(value = "id") Long id) {
        VesselDto vesselDto = vesselService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vessel doesn't exist"));
        List<ShipownerDto> shipowners = shipownerService.findAll();
        List<CountryDto> countries = countryService.findAll();
        List<CommercialOperatorDto> commercialOperators =
                commercialOperatorService.findAll();
        List<TechnicalOperatorDto> technicalOperators =
                technicalOperatorService.findAll();
        List<IceClass> iceClasses =
                new ArrayList<>(Arrays.asList(IceClass.values()));
        model.addAttribute("vessel", vesselDto);
        model.addAttribute("shipowners", shipowners);
        model.addAttribute("countries", countries);
        model.addAttribute("commercialOperators", commercialOperators);
        model.addAttribute("technicalOperators", technicalOperators);
        model.addAttribute("iceClasses", iceClasses);
        return "vessel/vessel";
    }

    @PostMapping("/vessels/save")
    public String saveVessel(VesselDto vesselDto) {
        CountryDto countryDto = countryService.findById(Long.
                parseLong(vesselDto.getCountry().getRusName())).get();
        ShipownerDto shipownerDto = shipownerService.findById(Long.
                parseLong(vesselDto.getShipowner().getName())).get();
        CommercialOperatorDto commercialOperatorDto = commercialOperatorService.findById(Long.
                parseLong(vesselDto.getCommercialOperator().getName())).get();
        TechnicalOperatorDto technicalOperatorDto = technicalOperatorService.findById(Long.
                parseLong(vesselDto.getTechnicalOperator().getName())).get();
        vesselDto.setCountry(countryDto);
        vesselDto.setShipowner(shipownerDto);
        vesselDto.setCommercialOperator(commercialOperatorDto);
        vesselDto.setTechnicalOperator(technicalOperatorDto);
        vesselDto.setId(null);
        vesselDto.setValidFrom(new Date());
        val saveVesselDto = vesselService.save(vesselDto);
        if (vesselWrapperService.existsByImo(vesselDto.getImo())) {
            VesselWrapperDto vesselWrapperDto =
                    vesselWrapperService.findByImo(vesselDto.getImo()).get();
            val espVesselDto = vesselWrapperDto.getCurrentVesselData();
            espVesselDto.setValidTill(new Date());
            vesselService.save(espVesselDto);
            vesselWrapperDto.setName(vesselDto.getName());
            vesselWrapperDto.setCurrentVesselData(saveVesselDto);
            vesselWrapperService.save(vesselWrapperDto);
        } else {
            val vesselWrapperDtoNew = new VesselWrapperDto();
            vesselWrapperDtoNew.setImo(vesselDto.getImo());
            vesselWrapperDtoNew.setName(vesselDto.getName());
            vesselWrapperDtoNew.setCurrentVesselData(saveVesselDto);
            vesselWrapperService.save(vesselWrapperDtoNew);
        }
        return "redirect:/vessels";
    }
}
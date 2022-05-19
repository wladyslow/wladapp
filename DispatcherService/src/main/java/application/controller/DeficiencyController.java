package application.controller;


import application.dto.*;
import application.enums.DeficiencyStatus;
import application.mapper.*;
import application.repository.ComOperatorDeficiencyRepository;
import application.repository.TechOperatorDeficiencyRepository;
import application.repository.VesselDeficiencyRepository;
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
import java.util.List;

@Controller
@Validated
@RequiredArgsConstructor
public class DeficiencyController {

    private final VesselWrapperService vesselWrapperService;
    private final VesselWrapperMapper vesselWrapperMapper;
    private final CommercialOperatorService commercialOperatorService;
    private final CommercialOperatorMapper commercialOperatorMapper;
    private final TechnicalOperatorService technicalOperatorService;
    private final TechnicalOperatorMapper technicalOperatorMapper;
    private final VesselDeficiencyMapper vesselDeficiencyMapper;
    private final VesselDeficiencyRepository vesselDeficiencyRepository;
    private final ComOperatorDeficiencyMapper comOperatorDeficiencyMapper;
    private final ComOperatorDeficiencyRepository comOperatorDeficiencyRepository;
    private final TechOperatorDeficiencyMapper techOperatorDeficiencyMapper;
    private final TechOperatorDeficiencyRepository techOperatorDeficiencyRepository;
    private final VesselDeficiencyService vesselDeficiencyService;
    private final TechOperatorDeficiencyService techOperatorDeficiencyService;
    private final ComOperatorDeficiencyService comOperatorDeficiencyService;

    @GetMapping("/vessels/def/{id}")
    public String showDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        VesselWrapperDto vesselWrapperDto = vesselWrapperService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vessel doesn't exist"));
        model.addAttribute("vesselWrapper", vesselWrapperDto);
        return "vessel/deficiency";
    }

    @GetMapping("/vessels/def/add/{id}")
    public String addDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        val vesselWrapperDto = vesselWrapperService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vessel doesn't exist"));
        val vesselDeficiencyDto = new VesselDeficiencyDto();
        List<DeficiencyStatus> defStatuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("vesselWrapper", vesselWrapperDto);
        model.addAttribute("deficiency", vesselDeficiencyDto);
        model.addAttribute("defStatuses", defStatuses);
        return "vessel/deficiencyAdd";
    }

    @PostMapping("vessels/def/save/{id}")
    public String saveVesselDeficiency(@PathVariable(value = "id") Long id,
                                       VesselDeficiencyDto vesselDeficiencyDto) {
        val vesselDeficiency = vesselDeficiencyMapper.toEntity(vesselDeficiencyDto);
        vesselDeficiency.setVesselWrapper(vesselWrapperMapper.toEntity(vesselWrapperService.findById(id).get()));
        vesselDeficiencyRepository.save(vesselDeficiency);
        return "redirect:/vessels";
    }

    @PostMapping("vessels/def/save")
    public String saveEditedVesselDeficiency(VesselDeficiencyDto vesselDeficiencyDto) {
        val deficiency = vesselDeficiencyRepository.findById(vesselDeficiencyDto.getId());
        deficiency.get().setComments(vesselDeficiencyDto.getComments());
        deficiency.get().setDeficiency(vesselDeficiencyDto.getDeficiency());
        deficiency.get().setDeficiencyDate(vesselDeficiencyDto.getDeficiencyDate());
        deficiency.get().setDeficiencyStatus(vesselDeficiencyDto.getDeficiencyStatus());
        vesselDeficiencyRepository.save(deficiency.get());
        return "redirect:/vessels";
    }

    @PostMapping("comdef/save")
    public String saveEditedComlDeficiency(ComOperatorDeficiencyDto dto) {
        val deficiency = comOperatorDeficiencyRepository.findById(dto.getId());
        deficiency.get().setComments(dto.getComments());
        deficiency.get().setDeficiency(dto.getDeficiency());
        deficiency.get().setDeficiencyDate(dto.getDeficiencyDate());
        deficiency.get().setDeficiencyStatus(dto.getDeficiencyStatus());
        comOperatorDeficiencyRepository.save(deficiency.get());
        return "redirect:/vessels";
    }

    @PostMapping("techdef/save")
    public String saveEditedTechDeficiency(TechOperatorDeficiencyDto dto) {
        val deficiency = techOperatorDeficiencyRepository.findById(dto.getId());
        deficiency.get().setComments(dto.getComments());
        deficiency.get().setDeficiency(dto.getDeficiency());
        deficiency.get().setDeficiencyDate(dto.getDeficiencyDate());
        deficiency.get().setDeficiencyStatus(dto.getDeficiencyStatus());
        techOperatorDeficiencyRepository.save(deficiency.get());
        return "redirect:/vessels";
    }

    @GetMapping("/vessels/comdef/add/{id}")
    public String addComDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        val commercialOperatorDto = commercialOperatorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Operator doesn't exist"));
        val comOperatorDeficiencyDto = new ComOperatorDeficiencyDto();
        List<DeficiencyStatus> defStatuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("operator", commercialOperatorDto);
        model.addAttribute("deficiency", comOperatorDeficiencyDto);
        model.addAttribute("defStatuses", defStatuses);
        return "vessel/deficiencyAddCom";
    }

    @PostMapping("vessels/comdef/save/{id}")
    public String saveComOpDeficiency(@PathVariable(value = "id") Long id,
                                      ComOperatorDeficiencyDto comOperatorDeficiencyDto) {
        val comOperDef = comOperatorDeficiencyMapper.toEntity(comOperatorDeficiencyDto);
        comOperDef.setCommercialOperator(commercialOperatorMapper
                .toEntity(commercialOperatorService.findById(id).get()));
        comOperatorDeficiencyRepository.save(comOperDef);
        return "redirect:/vessels";
    }

    @GetMapping("/vessels/techdef/add/{id}")
    public String addTechDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        val techniaclOperatorDto = technicalOperatorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Operator doesn't exist"));
        val techOperatorDeficiencyDto = new TechOperatorDeficiencyDto();
        List<DeficiencyStatus> defStatuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("operator", techniaclOperatorDto);
        model.addAttribute("deficiency", techOperatorDeficiencyDto);
        model.addAttribute("defStatuses", defStatuses);
        return "vessel/deficiencyAddTech";
    }

    @PostMapping("vessels/techdef/save/{id}")
    public String saveTechOpDeficiency(@PathVariable(value = "id") Long id,
                                       TechOperatorDeficiencyDto techOperatorDeficiencyDto) {
        val techOperDef = techOperatorDeficiencyMapper.toEntity(techOperatorDeficiencyDto);
        techOperDef.setTechnicalOperator(technicalOperatorMapper
                .toEntity(technicalOperatorService.findById(id).get()));
        techOperatorDeficiencyRepository.save(techOperDef);
        return "redirect:/vessels";
    }

    @GetMapping("/vesselcomdef/edit/{id}")
    public String editComDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        val deficiencyDto = comOperatorDeficiencyService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Deficiency doesn't exist"));
        List<DeficiencyStatus> defStatuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("operator", deficiencyDto);
        model.addAttribute("defStatuses", defStatuses);
        return "vessel/comdeficiencyEdit";
    }

    @GetMapping("/vesseltechdef/edit/{id}")
    public String editTechDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        val deficiencyDto = techOperatorDeficiencyService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Deficiency doesn't exist"));
        List<DeficiencyStatus> defStatuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("operator", deficiencyDto);
        model.addAttribute("defStatuses", defStatuses);
        return "vessel/techdeficiencyEdit";
    }

    @GetMapping("/vesseldef/edit/{id}")
    public String editDeficiencyViewer(Model model, @PathVariable(value = "id") Long id) {
        val vesselDeficiency = vesselDeficiencyService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Deficiency doesn't exist"));
        List<DeficiencyStatus> defStatuses =
                new ArrayList<>(Arrays.asList(DeficiencyStatus.values()));
        model.addAttribute("operator", vesselDeficiency);
        model.addAttribute("defStatuses", defStatuses);
        return "vessel/deficiencyEdit";
    }
}

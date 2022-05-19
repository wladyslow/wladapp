package application.service.impl;

import application.dto.VesselDeficiencyDto;
import application.dto.VesselWrapperDto;
import application.mapper.VesselDeficiencyMapper;
import application.mapper.VesselWrapperMapper;
import application.repository.VesselDeficiencyRepository;
import application.service.VesselDeficiencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VesselDeficiencyServiceImpl implements VesselDeficiencyService {

    private final VesselDeficiencyRepository vesselDeficiencyRepository;
    private final VesselDeficiencyMapper vesselDeficiencyMapper;
    private final VesselWrapperMapper vesselWrapperMapper;

    @Override
    public List<VesselDeficiencyDto> findAll() {
        return vesselDeficiencyMapper.toDtos(vesselDeficiencyRepository.findAll());
    }

    @Override
    public List<VesselDeficiencyDto> findByVesselWrapperOperator(VesselWrapperDto vesselWrapper) {
        return vesselDeficiencyMapper.toDtos(
                vesselDeficiencyRepository.findByVesselWrapper(vesselWrapperMapper.toEntity(vesselWrapper))
        );
    }

    @Override
    public Optional<VesselDeficiencyDto> findById(Long id) {
        return vesselDeficiencyMapper.toOptional(vesselDeficiencyRepository.findById(id));
    }

    @Override
    public VesselDeficiencyDto save(VesselDeficiencyDto vesselDeficiencyDto) {
        return vesselDeficiencyMapper.toDto(vesselDeficiencyRepository.
                save(vesselDeficiencyMapper.toEntity(vesselDeficiencyDto)));
    }
}

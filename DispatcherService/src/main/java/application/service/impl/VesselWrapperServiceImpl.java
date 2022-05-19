package application.service.impl;

import application.dto.VesselDto;
import application.dto.VesselWrapperDto;
import application.mapper.VesselMapper;
import application.mapper.VesselWrapperMapper;
import application.repository.VesselWrapperRepository;
import application.service.VesselWrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VesselWrapperServiceImpl implements VesselWrapperService {

    private final VesselWrapperRepository vesselWrapperRepository;
    private final VesselWrapperMapper vesselWrapperMapper;
    private final VesselMapper vesselMapper;

    @Override
    public List<VesselWrapperDto> findAll() {
        return vesselWrapperMapper.toDtos(vesselWrapperRepository.findAll());
    }

    @Override
    public Optional<VesselWrapperDto> findByImo(int imo) {
        return vesselWrapperMapper.toOptional(vesselWrapperRepository.findByImo(imo));
    }

    @Override
    public Optional<VesselWrapperDto> findById(Long id) {
        return vesselWrapperMapper.toOptional(vesselWrapperRepository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        vesselWrapperRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String name, VesselDto currentVesselData) {
        vesselWrapperRepository.findById(id).ifPresent(vw -> {
            vw.setName(name);
            vw.setCurrentVesselData(vesselMapper.toEntity(currentVesselData));
        });
    }

    @Override
    public boolean existsByImo(int imo) {
        return vesselWrapperRepository.existsVesselWrapperByImo(imo);
    }

    @Override
    public VesselWrapperDto save(VesselWrapperDto vesselWrapperDto) {
        return vesselWrapperMapper.toDto(vesselWrapperRepository.save(vesselWrapperMapper.toEntity(vesselWrapperDto)));
    }
}

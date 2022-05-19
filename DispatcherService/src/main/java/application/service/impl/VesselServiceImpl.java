package application.service.impl;

import application.enums.IceClass;
import lombok.RequiredArgsConstructor;
import lombok.val;
import application.mapper.VesselMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.VesselRepository;
import application.service.VesselService;
import application.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VesselServiceImpl implements VesselService {

    private final VesselRepository vesselRepository;
    private final VesselMapper vesselMapper;

    @Override
    @Transactional
    public Long createVessel(String name,
                             String type, int imo, double dspl, double dwt,
                             double loa, double beam, double height, int gt,
                             int swbt, int rgt, int year, ShipownerDto shipowner,
                             CountryDto country, String eMail, CommercialOperatorDto commercialOperator,
                             TechnicalOperatorDto technicalOperator, IceClass iceClass, Date validFrom) {
        val vesselDto = new VesselDto(name, type, imo, dspl, dwt, loa, beam, height, gt,
                swbt, rgt, year, shipowner, country, eMail, commercialOperator, technicalOperator, iceClass,
                validFrom);
        val vessel = vesselMapper.toEntity(vesselDto);
        vesselRepository.save(vessel);
        return vessel.getId();
    }

    @Override
    @Transactional
    public List<VesselDto> findAll() {
        return vesselMapper.toDtos(vesselRepository.findAllByOrderByNameAsc());
    }

    @Override
    public VesselDto save(VesselDto vesselDto) {
        return vesselMapper.toDto(vesselRepository.save(vesselMapper.toEntity(vesselDto)));
    }

    @Override
    @Transactional
    public Optional<VesselDto> findById(Long id) {
        return vesselMapper.toOptional(vesselRepository.findById(id));
    }

    @Override
    @Transactional
    public Optional<VesselDto> findByName(String name) {
        return vesselMapper.toOptional(vesselRepository.findByName(name));
    }

    @Override
    @Transactional
    public Optional<VesselDto> findByImo(int imo) {
        return vesselMapper.toOptional(vesselRepository.findByImo(imo));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        vesselRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, String name, String type,
                       int imo, double dspl, double dwt, double loa, double beam, double height,
                       int gt, int swbt, int rgt, int year, ShipownerDto shipowner, CountryDto country,
                       String eMail, CommercialOperatorDto commercialOperator, TechnicalOperatorDto technicalOperator,
                       IceClass iceClass, Date validFrom) {
        vesselRepository.findById(id).ifPresent(vessel -> {
            if (vessel.getName().equals(name)) {
                val vesselDto = new VesselDto(name, type, imo, dspl, dwt, loa, beam, height, gt,
                        swbt, rgt, year, shipowner, country, eMail, commercialOperator, technicalOperator, iceClass,
                        validFrom);
                val vsl = vesselMapper.toEntity(vesselDto);
                vesselRepository.save(vsl);
            }
        });
    }
}

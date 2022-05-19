package application.service.impl;

import application.entities.Cargo;
import application.dto.*;
import application.entities.LoadingWindow;
import application.entities.Shipper;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import application.mapper.*;
import application.repository.CargoRepository;
import application.repository.ShipperRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import application.repository.LoadingWindowRepository;
import application.service.LoadingWindowService;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoadingWindowServiceImpl implements LoadingWindowService {

    private final LoadingWindowRepository loadingWindowRepository;
    private final LoadingWindowMapper loadingWindowMapper;
    private final CargoMapper cargoMapper;
    private final ShipperMapper shipperMapper;
    private final ClearedVesselMapper clearedVesselMapper;
    private final VesselToClearMapper vesselToClearMapper;
    private final CargoRepository cargoRepository;
    private final ShipperRepository shipperRepository;

    @Override
    @Transactional
    public Long createLoadingWindow(CargoDto cargo, LoadingWindowType type,
                                    int positionNumber, String positionPostfix,
                                    LoadingWindowStatus status, ShipperDto shipper,
                                    Date initDate, Date loadDate,
                                    List<VesselToClearDto> vesselToClearList, List<ClearedVesselDto> clearedVesselList) {
        val loadingWindowDto = new LoadingWindowDto(cargo, type, positionNumber, positionPostfix,
                status, shipper, initDate, loadDate, vesselToClearList, clearedVesselList);
        val loadingWindow = loadingWindowMapper.toEntity(loadingWindowDto);
        Cargo cargoFromSting = cargoRepository.getById(Long.parseLong(cargo.getType()));
        Shipper shipperFromString = shipperRepository.getById(Long.parseLong(shipper.getName()));
        loadingWindow.setCargo(cargoFromSting);
        loadingWindow.setShipper(shipperFromString);
        loadingWindowRepository.save(loadingWindow);
        return loadingWindow.getId();
    }

    @Override
    @Transactional
    public LoadingWindowDto save(LoadingWindowDto loadingWindowDto) {
        return loadingWindowMapper.toDto(loadingWindowRepository
                .save(loadingWindowMapper.toEntity(loadingWindowDto)));
    }

    @Override
    @Transactional
    public List<LoadingWindowDto> findAll() {
        return loadingWindowMapper.toDtos(loadingWindowRepository.findAll());
    }

    @Override
    @Transactional
    public LoadingWindowMonthDto getPage(Pageable pageable) {
        Page<LoadingWindow> currentPage = loadingWindowRepository.findAll(pageable);
        return new LoadingWindowMonthDto(loadingWindowMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional
    public Optional<LoadingWindowDto> findById(Long id) {
        return loadingWindowMapper.toOptional(loadingWindowRepository.findById(id));
    }

    @Override
    @Transactional
    public List<LoadingWindowDto> findByCargo(Cargo cargo) {
        return loadingWindowMapper.toDtos(loadingWindowRepository.findByCargo(cargo));
    }

    @Override
    @Transactional
    public List<LoadingWindowDto> findByInitDate(Date initDate) {
        return loadingWindowMapper.toDtos(loadingWindowRepository.findByInitDate(initDate));
    }

    @Override
    @Transactional
    public List<LoadingWindowDto> findByYearMonth(String yearMonth) {
        return loadingWindowMapper.toDtos(loadingWindowRepository.findByYearMonth(yearMonth));
    }

    @Override
    @Transactional
    public List<LoadingWindowDto> findByYearMonthAndCargo(String yearMonth, Cargo cargo) {
        return loadingWindowMapper.toDtos(loadingWindowRepository.findByYearMonthAndCargo(yearMonth, cargo));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        loadingWindowRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, LoadingWindowType type,
                       LoadingWindowStatus status,
                       List<VesselToClearDto> vesselToClearList, List<ClearedVesselDto> clearedVesselList) {
        loadingWindowRepository.findById(id).ifPresent(lw -> {
            lw.setType(type);
            lw.setStatus(status);
            lw.setVesselToClearList(vesselToClearMapper.toEntities(vesselToClearList));
            lw.setClearedVesselList(clearedVesselMapper.toEntities(clearedVesselList));
            loadingWindowRepository.save(lw);
        });
    }
}

package application.service.impl;

import application.entities.Cargo;
import application.dto.*;
import application.entities.LoadingWindow;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import lombok.RequiredArgsConstructor;
import lombok.val;
import application.mapper.LoadingWindowMapper;
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

    @Override
    @Transactional
    public Long createLoadingWindow(CargoDto cargo, LoadingWindowType type,
                                    int positionNumber, String positionPostfix,
                                    LoadingWindowStatus status, List<ShipperQuantityDto> shipperQuantities,
                                    String initDate, String loadDate, List<LoadingOrderDto> loadingOrders,
                                    List<VesselToClearDto> vesselToClearList, List<ClearedVesselDto> clearedVessels) {
        val loadingWindowDto = new LoadingWindowDto(cargo, type, positionNumber, positionPostfix,
                status, shipperQuantities, initDate, loadDate, loadingOrders, vesselToClearList, clearedVessels);
        val loadingWindow = loadingWindowMapper.toEntity(loadingWindowDto);
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
        //return loadingWindowRepository.findAll();
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
       // return loadingWindowMapper.toDtos(loadingWindowRepository.findByYearMonth(yearMonth));
        return loadingWindowMapper.toDtos(loadingWindowRepository.findByYearMonth(yearMonth));
    }

    @Override
    @Transactional
    public List<LoadingWindowDto> findByYearMonthAndCargo(YearMonth yearMonth, Cargo cargo) {
        return loadingWindowMapper.toDtos(loadingWindowRepository.findByYearMonthAndCargo(yearMonth, cargo));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        loadingWindowRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, String name) {

    }
}

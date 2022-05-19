package application.service;

import application.entities.Cargo;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import org.springframework.data.domain.Pageable;
import application.dto.*;

import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LoadingWindowService {

    Long createLoadingWindow(CargoDto cargo, LoadingWindowType type, int positionNumber,
                             String positionPostfix, LoadingWindowStatus status,
                             ShipperDto shipper, Date initDate,
                             Date loadDate, List<VesselToClearDto> vesselToClearList,
                             List<ClearedVesselDto> clearedVesselList);

    LoadingWindowDto save(LoadingWindowDto loadingWindowDto);

    List<LoadingWindowDto> findAll();

    LoadingWindowMonthDto getPage(Pageable pageable);

    Optional<LoadingWindowDto> findById(Long id);

    List<LoadingWindowDto> findByCargo(Cargo cargo);

    List<LoadingWindowDto> findByInitDate(Date initDate);

    List<LoadingWindowDto> findByYearMonth(String yearMonth);

    List<LoadingWindowDto> findByYearMonthAndCargo(String yearMonth, Cargo cargo);

    void deleteById(Long id);

    void update(Long id, LoadingWindowType type,
                LoadingWindowStatus status,
                List<VesselToClearDto> vesselToClearList,
                List<ClearedVesselDto> clearedVesselList);
}

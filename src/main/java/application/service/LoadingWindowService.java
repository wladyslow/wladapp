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
                             List<ShipperQuantityDto> shipperQuantities, String initDate,
                             String loadDate, List<LoadingOrderDto> loadingOrders,
                             List<VesselToClearDto> vesselToClearList,
                             List<ClearedVesselDto> clearedVessels);

    LoadingWindowDto save(LoadingWindowDto loadingWindowDto);

    List<LoadingWindowDto> findAll();

    LoadingWindowMonthDto getPage(Pageable pageable);

    Optional<LoadingWindowDto> findById(Long id);

    List<LoadingWindowDto> findByCargo(Cargo cargo);

    List<LoadingWindowDto> findByInitDate(Date initDate);

    List<LoadingWindowDto> findByYearMonth(String yearMonth);

    List<LoadingWindowDto> findByYearMonthAndCargo(YearMonth yearMonth, Cargo cargo);

    void deleteById(Long id);

    void update(Long id, String name);//TODO: develop update for Loading Window;
}

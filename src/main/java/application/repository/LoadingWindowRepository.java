package application.repository;

import application.entities.Cargo;
import application.entities.LoadingWindow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.YearMonth;
import java.util.Date;
import java.util.List;

public interface LoadingWindowRepository extends JpaRepository<LoadingWindow, Long> {

    List<LoadingWindow> findByCargo(Cargo cargo);

    List<LoadingWindow> findByInitDate(Date initDate);

    List<LoadingWindow> findByYearMonth(String yearMonth);

    List<LoadingWindow> findByYearMonthAndCargo(YearMonth yearMonth, Cargo cargo);
}

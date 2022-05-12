package application.dto;

import application.entities.Shipper;
import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoadingWindowDto {

    private Long id;

    private CargoDto cargo;

    private LoadingWindowType type;

    private int positionNumber;

    private String positionPostfix;

    private LoadingWindowStatus status;

    private ShipperDto shipper;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date initDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loadDate;

    private String initDateString;

    private String loadDateString;

    private String yearMonth;

    private List<VesselToClearDto> vesselToClearList;

    private List<ClearedVesselDto> clearedVesselList;

    public LoadingWindowDto(CargoDto cargo, LoadingWindowType type,
                            int positionNumber, String positionPostfix,
                            LoadingWindowStatus status, ShipperDto shipper,
                            Date initDate, Date loadDate,
                            List<VesselToClearDto> vesselToClearList,
                            List<ClearedVesselDto> clearedVesselList) {
        this.cargo = cargo;
        this.type = type;
        this.positionNumber = positionNumber;
        this.positionPostfix = positionPostfix;
        this.status = status;
        this.shipper = shipper;
        this.initDate = initDate;
        this.loadDate = loadDate;
        this.vesselToClearList = vesselToClearList;
        this.clearedVesselList = clearedVesselList;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
        String dateString = new SimpleDateFormat("dd.MM.yyyy").format(loadDate);
        String[] loadDateStringArray = dateString.split("\\.");
        this.yearMonth = loadDateStringArray[2] + "-" +
                loadDateStringArray[1];
        this.loadDateString = loadDateStringArray[0] + "." +loadDateStringArray[1] +
                "." + loadDateStringArray[2];
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
        String dateString = new SimpleDateFormat("dd.MM.yyyy").format(initDate);
        String[] initDateStringArray = dateString.split("\\.");
        this.initDateString = initDateStringArray[0] + "." +initDateStringArray[1] +
                "." + initDateStringArray[2];
    }

    public String getCustomYearMonth() {
        String dateString = new SimpleDateFormat("dd.MM.yyyy").format(this.loadDate);
        String[] loadDateStringArray = dateString.split("\\.");
        return loadDateStringArray[2] + "-" +
                loadDateStringArray[1];
    }
}

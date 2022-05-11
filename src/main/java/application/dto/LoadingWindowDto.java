package application.dto;

import application.enums.LoadingWindowStatus;
import application.enums.LoadingWindowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private List<ShipperQuantityDto> shipperQuantityList;

    private String initDate;

    private String loadDate;

    private String yearMonth;

    private List<LoadingOrderDto> loadingOrderList;

    private List<VesselToClearDto> vesselToClearList;

    private List<ClearedVesselDto> clearedVesselList;

    public LoadingWindowDto(CargoDto cargo, LoadingWindowType type, int positionNumber,
                            String positionPostfix, LoadingWindowStatus status,
                            List<ShipperQuantityDto> shipperQuantities, String initDate,
                            String loadDate, List<LoadingOrderDto> loadingOrders,
                            List<VesselToClearDto> vesselToClearList,
                            List<ClearedVesselDto> clearedVessels) {
        this.cargo = cargo;
        this.type = type;
        this.positionNumber = positionNumber;
        this.positionPostfix = positionPostfix;
        this.status = status;
        this.shipperQuantityList = shipperQuantities;
        this.initDate = initDate;
        this.loadDate = loadDate;
        this.yearMonth = getCustomYearMonth();
        this.loadingOrderList = loadingOrders;
        this.vesselToClearList = vesselToClearList;
        this.clearedVesselList = clearedVessels;
    }

    public void SetCustomYearMonth(){
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
        //String loadDateString = simpleDateFormat.format(this.loadDate);
        String[]loadDateStringArray = this.loadDate.split("-");
        this.yearMonth = loadDateStringArray[0] + "-" +
                loadDateStringArray[1];
    }
    public String getCustomYearMonth(){
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
        // String loadDateString = simpleDateFormat.format(this.loadDate);
        String[]loadDateStringArray = this.loadDate.split("-");
        return loadDateStringArray[0] + "-"+
                loadDateStringArray[1];
    }
}

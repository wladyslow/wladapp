package application.entities;

import application.enums.LoadingWindowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import application.enums.LoadingWindowStatus;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOADING_WINDOW")
public class LoadingWindow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "CARGO_ID")
    private Cargo cargo;

    @Column
    private LoadingWindowType type;

    @Column
    private int positionNumber;

    @Column
    private String positionPostfix;

    @Column
    private LoadingWindowStatus status;

    @OneToMany(mappedBy = "loadingWindow")
    private List<ShipperQuantity> shipperQuantityList;

    @Column
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String initDate;

    @Column
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String loadDate;

    @Column
    private String yearMonth;

    @OneToMany(mappedBy = "loadingWindow")
    private List<LoadingOrder> loadingOrderList;

    @OneToMany(mappedBy = "loadingWindow")
    private List<VesselToClear> vesselToClearList;

    @OneToMany(mappedBy = "loadingWindow")
    private List<ClearedVessel> clearedVesselList;

    public LoadingWindow(Cargo cargo, LoadingWindowType type, int positionNumber,
                         String positionPostfix, LoadingWindowStatus status,
                         List<ShipperQuantity> shipperQuantities, String initDate,
                         String loadDate, List<LoadingOrder> loadingOrders,
                         List<VesselToClear> vesselToClearList, List<ClearedVessel> clearedVessels) {
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

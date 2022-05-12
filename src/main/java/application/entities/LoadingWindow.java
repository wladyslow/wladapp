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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "SHIPPER_ID")
    private Shipper shipper;

    @Column
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date initDate;

    @Column
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date loadDate;

    @Column
    private String yearMonth;

    @OneToMany(mappedBy = "loadingWindow")
    private List<VesselToClear> vesselToClearList;

    @OneToMany(mappedBy = "loadingWindow")
    private List<ClearedVessel> clearedVesselList;

    public LoadingWindow(Cargo cargo, LoadingWindowType type,
                         int positionNumber, String positionPostfix,
                         LoadingWindowStatus status, Shipper shipper,
                         Date initDate, Date loadDate,
                         List<VesselToClear> vesselToClearList,
                         List<ClearedVessel> clearedVesselList) {
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

/*    public void setCustomYearMonth() {
        String[] loadDateStringArray = this.loadDate.split("\\.");
        this.yearMonth = loadDateStringArray[2] + "-" +
                loadDateStringArray[1];
    }

    public String getCustomYearMonth() {
        String[] loadDateStringArray = this.loadDate.split("\\.");
        return loadDateStringArray[2] + "-" +
                loadDateStringArray[1];
    }*/
}

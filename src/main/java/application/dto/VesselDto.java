package application.dto;

import application.enums.IceClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselDto {

    private Long id;

    private VesselWrapperDto vesselWrapper;

    private String name;

    private String type;

    private int imo;

    private double dspl;

    private double dwt;

    private double loa;

    private double beam;

    private double height;

    private int gt;

    private int swbt;

    private int rgt;

    private int year;

    private ShipownerDto shipowner;

    private CountryDto country;

    private String eMail;

    private CommercialOperatorDto commercialOperator;

    private TechnicalOperatorDto technicalOperator;

    private IceClass iceClass;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validTill;

    public VesselDto(VesselWrapperDto vesselWrapper, String name, String type,
                     int imo, double dspl, double dwt, double loa, double beam,
                     double height, int gt, int swbt, int rgt, int year, ShipownerDto shipowner,
                     CountryDto country, String eMail, CommercialOperatorDto commercialOperator,
                     TechnicalOperatorDto technicalOperator, IceClass iceClass, Date validFrom, Date validTill) {
        this.vesselWrapper = vesselWrapper;
        this.name = name;
        this.type = type;
        this.imo = imo;
        this.dspl = dspl;
        this.dwt = dwt;
        this.loa = loa;
        this.beam = beam;
        this.height = height;
        this.gt = gt;
        this.swbt = swbt;
        this.rgt = rgt;
        this.year = year;
        this.shipowner = shipowner;
        this.country = country;
        this.eMail = eMail;
        this.commercialOperator = commercialOperator;
        this.technicalOperator = technicalOperator;
        this.iceClass = iceClass;
        this.validFrom = validFrom;
        this.validTill = validTill;
    }
}
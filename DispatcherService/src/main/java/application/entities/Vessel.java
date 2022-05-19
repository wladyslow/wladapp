package application.entities;

import application.enums.IceClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VESSEL")
public class Vessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private int imo;

    @Column
    private double dspl;

    @Column
    private double dwt;

    @Column
    private double loa;

    @Column
    private double beam;

    @Column
    private double height;

    @Column
    private int gt;

    @Column
    private int swbt;

    @Column
    private int rgt;

    @Column
    private int year;

    @ManyToOne
    @JoinColumn(name = "SHIPOWNER_ID", nullable = false)
    private Shipowner shipowner;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country;

    @Column
    private String eMail;

    @ManyToOne
    @JoinColumn(name = "COMMERCIALOPERATOR_ID", nullable = false)
    private CommercialOperator commercialOperator;

    @ManyToOne
    @JoinColumn(name = "TECHNICALOPERATOR_ID", nullable = false)
    private TechnicalOperator technicalOperator;

    @Column
    private IceClass iceClass;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validFrom;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validTill;

    public Vessel(String name, String type,
                  int imo, double dspl, double dwt, double loa, double beam,
                  double height, int gt, int swbt, int rgt, int year, Shipowner shipowner,
                  Country country, String eMail, CommercialOperator commercialOperator,
                  TechnicalOperator technicalOperator, IceClass iceClass, Date validFrom) {
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
    }
}
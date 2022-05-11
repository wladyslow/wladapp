package application.entities;

import application.enums.DeficiencyStatus;
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
@Table(name = "VESSEL_DEFICIENCY")
public class VesselDeficiency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VESSELWRAPPER_ID", nullable = false)
    private VesselWrapper vesselWrapper;

    @Column
    private String deficiency;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deficiencyDate;

    @Column
    private DeficiencyStatus deficiencyStatus;

    @Column
    private String comments;
}

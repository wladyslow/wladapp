package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VESSEL_WRAPPER")
public class VesselWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int imo;

    @OneToOne
    @JoinColumn(name = "VESSEL_ID", nullable = false)
    private Vessel currentVesselData;

    @ManyToMany
    @JoinTable(
            name = "VESSELWRAPPER_CAPTAIN",
            joinColumns = @JoinColumn(name = "VESSELWRAPPER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAPTAIN_ID"))
    private List<Captain> captains;

    @OneToMany(mappedBy = "vesselWrapper")
    private List<VesselDeficiency> vesselDeficiencies;
}

package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VESSEL_TO_CLEAR")
public class VesselToClear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VESSEL_WRAPPER_ID", nullable = false)
    private VesselWrapper vesselWrapper;

    @ManyToOne
    @JoinColumn(name = "LOADINGWINDOW_ID", nullable = false)
    private LoadingWindow loadingWindow;

    @Column
    private String technicalPart;

    @Column
    private String vettingPart;

    @Column
    private String comments;
}


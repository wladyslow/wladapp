package application.entities;

import application.enums.VesselToClearStatus;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VESSEL_WRAPPER_ID", nullable = false)
    private VesselWrapper vesselWrapper;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOADINGWINDOW_ID", nullable = false)
    private LoadingWindow loadingWindow;

    @Column
    private Long loadingWindowId;

    @Column
    private String technicalPart;

    @Column
    private String vettingPart;

    @Column
    private boolean vettingStatus;

    @Column
    private VesselToClearStatus status;

    @Column
    private String comments;

    @Column
    private boolean accepted;

    public VesselToClear(VesselWrapper vesselWrapper,
                         LoadingWindow loadingWindow,
                         Long loadingWindowId,
                         String technicalPart,
                         String vettingPart,
                         boolean vettingStatus,
                         VesselToClearStatus status,
                         String comments, boolean accepted) {
        this.vesselWrapper = vesselWrapper;
        this.loadingWindow = loadingWindow;
        this.loadingWindowId = loadingWindowId;
        this.technicalPart = technicalPart;
        this.vettingPart = vettingPart;
        this.vettingStatus = vettingStatus;
        this.status = status;
        this.comments = comments;
        this.accepted = accepted;
    }
}


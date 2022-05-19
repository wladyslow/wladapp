package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERFORMING_VESSEL")
public class PerformingVessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLEARED_VESSEL_ID", nullable = false)
    private ClearedVessel clearedVessel;

    @ManyToOne
    @JoinColumn(name = "LOADINGWINDOW_ID", nullable = false)
    private LoadingWindow loadingWindow;

    @Column
    private String schedule;

    @Column
    private String handling;

    @Column
    private String sailed;
}


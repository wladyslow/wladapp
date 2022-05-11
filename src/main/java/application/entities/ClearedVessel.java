package application.entities;

import application.enums.DayPart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLEARED_VESSEL")
public class ClearedVessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VESSEL_ID", nullable = false)
    private Vessel vessel;

    @ManyToOne
    @JoinColumn(name = "LOADINGWINDOW_ID", nullable = false)
    private LoadingWindow loadingWindow;

    @ManyToOne
    @JoinColumn(name = "AGENT_ID", nullable = false)
    private Agent agent;

    @Column
    private LocalDate etaDate;

    @Column
    private LocalTime etaTime;

    @Column
    private DayPart dayPart;


}

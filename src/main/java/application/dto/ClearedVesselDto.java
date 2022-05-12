package application.dto;

import application.enums.DayPart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClearedVesselDto {

    private Long id;

    private VesselDto vessel;

    private String loadingWindowId;

    private AgentDto agent;

    private LocalDate etaDate;

    private LocalTime etaTime;

    private DayPart dayPart;

}

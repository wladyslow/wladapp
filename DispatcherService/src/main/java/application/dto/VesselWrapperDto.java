package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VesselWrapperDto {

    private Long id;

    private String name;

    private int imo;

    private VesselDto currentVesselData;

    private List<CaptainDto> captains;

    private List<VesselDeficiencyDto> vesselDeficiencies;
}

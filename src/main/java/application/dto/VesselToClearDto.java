package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VesselToClearDto {

    private Long id;

    private VesselWrapperDto vesselWrapperDto;

    private LoadingWindowDto loadingWindowDto;

    private String technicalPart;

    private String vettingPart;

    private String comments;
}


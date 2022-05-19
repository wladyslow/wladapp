package application.dto;

import application.enums.VesselToClearStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VesselToClearDto {

    private Long id;

    private VesselWrapperDto vesselWrapper;

    private Long loadingWindowId;

    private String technicalPart;

    private String vettingPart;

    private String comments;

    private boolean vettingStatus;

    private VesselToClearStatus status;

    private boolean accepted;

    public VesselToClearDto(String comments) {
        this.comments = comments;
    }
}


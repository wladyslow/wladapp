package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VesselClearanceDataDto {

    private Long vesselToClearId;

    private String vesselName;

    private int vesselImo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date initialDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loadingDate;

    private List<VesselDeficiencyDto> vesselDeficiencyList;

    private List<TechOperatorDeficiencyDto> techOperatorDeficiencyList;

    private List<ComOperatorDeficiencyDto> comOperatorDeficiencyList;
}

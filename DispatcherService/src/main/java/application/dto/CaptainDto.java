package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CaptainDto {

    private Long id;

    private String name;

    private List<VesselWrapperDto> vesselWrappers;

    public CaptainDto(String name) {
        this.name = name;
    }
}

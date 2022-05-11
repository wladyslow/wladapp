package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShipownerDto {

    private Long id;

    private String name;

    private String rusFullName;

    private String email;

    private List<VesselDto> vessels;
}


package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDto {

    private Long id;

    private String type;

    public CargoDto(String type) {
        this.type = type;
    }
}


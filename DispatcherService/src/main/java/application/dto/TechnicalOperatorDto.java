package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalOperatorDto {

    private Long id;

    private String name;

    private String email;

    private List<TechOperatorDeficiencyDto> techOperatorDeficiencies;

    public TechnicalOperatorDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public TechnicalOperatorDto(String name) {
        this.name = name;
    }
}


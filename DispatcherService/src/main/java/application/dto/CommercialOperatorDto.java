package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommercialOperatorDto {

    private Long id;

    private String name;

    private String email;

    private List<ComOperatorDeficiencyDto> comOperatorDeficiencies;

    public CommercialOperatorDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public CommercialOperatorDto(String name) {
        this.name = name;
    }
}



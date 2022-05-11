package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private Long id;

    private String number;

    public ContractDto(String number) {
        this.number = number;
    }
}

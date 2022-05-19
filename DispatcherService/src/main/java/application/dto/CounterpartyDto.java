package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CounterpartyDto {

    private Long id;

    private ContractDto contract;

    private String name;

    private String rusFullName;

    private String eMail;

    public CounterpartyDto(ContractDto contract, String name, String rusFullName, String eMail) {
        this.contract = contract;
        this.name = name;
        this.rusFullName = rusFullName;
        this.eMail = eMail;
    }
}


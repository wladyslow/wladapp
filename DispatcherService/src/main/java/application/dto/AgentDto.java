package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentDto extends CounterpartyDto {

    private Long id;

    private ContractDto contract;

    private String name;

    private String rusFullName;

    private String eMail;

    public AgentDto(ContractDto contract, String name, String rusFullName, String eMail) {
        super(contract, name, rusFullName, eMail);
    }
}

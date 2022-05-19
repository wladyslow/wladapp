package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipperDto {

    private Long id;

    private ContractDto contract;

    private String name;

    private String rusFullName;

    private String eMail;

    public ShipperDto(String name, String rusFullName, String eMail) {
        this.name = name;
        this.rusFullName = rusFullName;
        this.eMail = eMail;
    }

    public ShipperDto(String name) {
        this.name = name;
    }
}

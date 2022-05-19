package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShipownerDto {

    private Long id;

    private String name;

    private String rusFullName;

    private String email;

    public ShipownerDto(String name, String rusFullName, String email) {
        this.name = name;
        this.rusFullName = rusFullName;
        this.email = email;
    }

    public ShipownerDto(String name) {
        this.name = name;
    }
}


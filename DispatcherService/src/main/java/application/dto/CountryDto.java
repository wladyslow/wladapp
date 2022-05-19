package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private Long id;

    private String engName;

    private String rusName;

    public CountryDto(String rusName) {
        this.rusName = rusName;
    }

    public CountryDto(String engName, String rusName) {
        this.engName = engName;
        this.rusName = rusName;
    }
}

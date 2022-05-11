package application.dto;

import application.enums.DeficiencyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComOperatorDeficiencyDto {

    private Long id;

    private CommercialOperatorDto commercialOperator;

    private String deficiency;

    private Date deficiencyDate;

    private DeficiencyStatus deficiencyStatus;

    private String comments;
}

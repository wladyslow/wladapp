package application.dto;

import application.enums.DeficiencyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TechOperatorDeficiencyDto {

    private Long id;

    private TechnicalOperatorDto technicalOperator;

    private String deficiency;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deficiencyDate;

    private DeficiencyStatus deficiencyStatus;

    private String comments;
}


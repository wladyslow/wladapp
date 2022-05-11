package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RouteOrderDto {

    private Long id;

    private String number;

    private LoadingOrderDto loadingOrder;
}

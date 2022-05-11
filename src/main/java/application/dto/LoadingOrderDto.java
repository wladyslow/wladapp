package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadingOrderDto {

    private Long id;

    private ShipperDto shipper;

    private ForwarderDto forwarder;

    private String number;

    private List<RouteOrderDto> routeOrderList;

    private BigDecimal netLoadingQuantity;

    private BigDecimal grossLoadingQuantity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfIssue;

    private LoadingWindowDto loadingWindowDto;
}

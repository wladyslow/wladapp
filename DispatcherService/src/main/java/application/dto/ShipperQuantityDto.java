package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShipperQuantityDto {

    private Long id;

    private ShipperDto shipper;

    private int quantity;

    private Long loadingWindowId;

    public ShipperQuantityDto(ShipperDto shipper, int quantity) {
        this.shipper = shipper;
        this.quantity = quantity;
    }
}

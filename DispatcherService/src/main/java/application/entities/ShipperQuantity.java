package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SHIPPER_QUANTITY")

public class ShipperQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SHIPPER_ID")
    private Shipper shipper;

    @Column
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOADINGWINDOW_ID", nullable = false)
    private LoadingWindow loadingWindow;

    public ShipperQuantity(Shipper shipper, int quantity) {
        this.shipper = shipper;
        this.quantity = quantity;
    }
}

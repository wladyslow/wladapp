package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOADING_ORDER")
public class LoadingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "SHIPPER_ID", nullable = false)
    private Shipper shipper;

    @ManyToOne
    @JoinColumn(name = "FORWARDER_ID", nullable = false)
    private Forwarder forwarder;

    @Column
    private String number;

    @OneToMany(mappedBy="loadingOrder")
    private List<RouteOrder> routeOrderList;

    @Column
    private BigDecimal netLoadingQuantity;

    @Column
    private BigDecimal grossLoadingQuantity;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfIssue;

    @ManyToOne
    @JoinColumn(name = "LOADINGWINDOW_ID", nullable = false)
    private LoadingWindow loadingWindow;
}

package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROUTE_ORDER")
public class RouteOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String number;

    @ManyToOne
    @JoinColumn(name = "LOADING_ORDER_ID", nullable = false)
    private LoadingOrder loadingOrder;
}

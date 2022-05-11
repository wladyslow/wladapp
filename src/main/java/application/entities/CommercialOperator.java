package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMMERCIAL_OPERATOR")
public class CommercialOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy="commercialOperator")
    private List<Vessel> vessels;

    @OneToMany(mappedBy = "commercialOperator")
    private List<ComOperatorDeficiency> comOperatorDeficiencies;
}



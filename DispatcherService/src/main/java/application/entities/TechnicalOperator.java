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
@Table(name = "TECHNICAL_OPERATOR")
public class TechnicalOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy="technicalOperator")
    private List<Vessel> vessels;

    @OneToMany(mappedBy = "technicalOperator")
    private List<TechOperatorDeficiency> techOperatorDeficiencies;
}


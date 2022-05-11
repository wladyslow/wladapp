package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "AGENT")
public class Agent extends Counterparty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "CONTRACT_ID")
    private Contract contract;

    @Column
    private String name;

    @Column
    private String rusFullName;

    @Column
    private String eMail;

    public Agent(Contract contract, String name, String rusFullName, String eMail) {
        super(contract, name, rusFullName, eMail);
    }
}

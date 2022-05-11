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
@Table(name = "FORWARDER")
public class Forwarder extends Counterparty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID")
    private Contract contract;

    @Column
    private String name;

    @Column
    private String rusFullName;

    @Column
    private String eMail;
}


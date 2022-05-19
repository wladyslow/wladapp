package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SHIPPER")
public class Shipper {

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

    public Shipper(String name, String rusFullName, String eMail) {
        this.name = name;
        this.rusFullName = rusFullName;
        this.eMail = eMail;
    }
}

package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Counterparty {

    private Long id;

    private Contract contract;

    private String name;

    private String rusFullName;

    private String eMail;

    public Counterparty(Contract contract, String name, String rusFullName, String eMail) {
        this.contract = contract;
        this.name = name;
        this.rusFullName = rusFullName;
        this.eMail = eMail;
    }
}


package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

//@Entity
//@Table(name = "office")
@Data
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue
    private int officeId;

    private String officeName;

    @ManyToOne
    private Country country;

    public Office(String officeName, Country country) {
        this.officeName = officeName;
        this.country = country;
    }
}

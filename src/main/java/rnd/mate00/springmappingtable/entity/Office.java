package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "office")
@Data
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue
    private int officeId;

    private String officeName;

    public Office(String officeName) {
        this.officeName = officeName;
    }
}

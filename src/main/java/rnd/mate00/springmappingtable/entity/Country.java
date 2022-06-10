package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    private int countryId;

    private String countryName;


    public Country(String countryName) {
        this.countryName = countryName;
    }
}

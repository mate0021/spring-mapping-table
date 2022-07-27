package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

//@Entity
//@Table(name = "country")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    private int countryId;

    private String countryName;

    @ManyToOne
    private Region region;


    public Country(String countryName, Region region) {
        this.countryName = countryName;
        this.region = region;
    }
}

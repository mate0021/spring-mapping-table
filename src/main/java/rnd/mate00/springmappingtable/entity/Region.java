package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region")
@Data
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue
    private int regionId;

    private String regionName;


    public Region(String regionName) {
        this.regionName = regionName;
    }
}

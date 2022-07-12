package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Data
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue
    private int regionId;

    @Column(unique = true)
    private String regionName;


    public Region(String regionName) {
        this.regionName = regionName;
    }
}

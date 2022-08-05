package rnd.mate00.springmappingtable.entity.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sta_location_location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaticLocationLocation {

    @Id
    private int id;

    private String locationName;

    private String locationCode;

    @ManyToOne
    private StaticLocationCountry country;

    private String countryName;
}

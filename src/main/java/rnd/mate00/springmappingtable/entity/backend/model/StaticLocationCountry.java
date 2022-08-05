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
@Table(name = "sta_location_country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaticLocationCountry {

    @Id
    private int id;

    private String countryName;

    private String countryCode;

    @ManyToOne
    private StaticLocationRegion region;
}

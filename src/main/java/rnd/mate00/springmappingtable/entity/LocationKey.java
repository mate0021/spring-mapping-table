package rnd.mate00.springmappingtable.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LocationKey implements Serializable {

    private Region region;

    private Country country;

    private Office office;

    @ManyToOne
    public Region getRegion() {
        return region;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    @ManyToOne
    public Office getOffice() {
        return office;
    }

}

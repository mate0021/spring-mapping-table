package rnd.mate00.springmappingtable.entity.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sta_location_region")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaticLocationRegion {

    @Id
    private int id;

    private String regionName;
}

package rnd.mate00.springmappingtable.entity.backend.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rnd.mate00.springmappingtable.entity.backend.model.key.ProductRegionKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_region")
@Getter
@Setter
@NoArgsConstructor
public class BackendRegion {

    @EmbeddedId
    private ProductRegionKey productRegionKey;

    @Column
    private int jobId;
}

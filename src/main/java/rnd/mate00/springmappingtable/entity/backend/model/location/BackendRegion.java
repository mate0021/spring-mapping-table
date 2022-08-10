package rnd.mate00.springmappingtable.entity.backend.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rnd.mate00.springmappingtable.entity.backend.model.BackendProduct;
import rnd.mate00.springmappingtable.entity.backend.model.StaticLocationRegion;
import rnd.mate00.springmappingtable.entity.backend.model.key.ProductRegionKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "product_region")
@Getter
@Setter
@NoArgsConstructor
public class BackendRegion {

    @EmbeddedId
    private ProductRegionKey productRegionKey;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private BackendProduct product;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @MapsId("regionId")
    private StaticLocationRegion region;

    private int jobId;
}

package rnd.mate00.springmappingtable.entity.backend.model.key;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegionKey implements Serializable {

    private int productId;

    private int regionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRegionKey that = (ProductRegionKey) o;
        return productId == that.productId && regionId == that.regionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, regionId);
    }
}

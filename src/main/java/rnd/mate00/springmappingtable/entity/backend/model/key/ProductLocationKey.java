package rnd.mate00.springmappingtable.entity.backend.model.key;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductLocationKey implements Serializable {

    private int productId;

    private int locationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLocationKey that = (ProductLocationKey) o;
        return productId == that.productId && locationId == that.locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, locationId);
    }
}

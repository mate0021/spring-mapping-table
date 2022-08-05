package rnd.mate00.springmappingtable.entity.backend.model.key;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductCountryKey implements Serializable {

    private int productId;

    private int countryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCountryKey that = (ProductCountryKey) o;
        return productId == that.productId && countryId == that.countryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, countryId);
    }
}

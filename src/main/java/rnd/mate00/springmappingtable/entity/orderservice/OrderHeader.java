package rnd.mate00.springmappingtable.entity.orderservice;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "order_header")
@AttributeOverrides({
        @AttributeOverride(name = "shippingAddress.address", column = @Column(name = "shipping_address")),
        @AttributeOverride(name = "shippingAddress.city", column = @Column(name = "shipping_city")),
        @AttributeOverride(name = "shippingAddress.postalCode", column = @Column(name = "shipping_postalcode")),
        @AttributeOverride(name = "billingAddress.address", column = @Column(name = "billing_address")),
        @AttributeOverride(name = "billingAddress.city", column = @Column(name = "billing_city")),
        @AttributeOverride(name = "billingAddress.postalCode", column = @Column(name = "billing_postalcode")),
})
public class OrderHeader extends BaseEntity {

    private String customer;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Address billingAddress;

    public OrderHeader() {
    }

    public OrderHeader(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderHeader)) return false;
        if (!super.equals(o)) return false;
        OrderHeader that = (OrderHeader) o;
        return Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(billingAddress, that.billingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCustomer(), shippingAddress, billingAddress);
    }
}

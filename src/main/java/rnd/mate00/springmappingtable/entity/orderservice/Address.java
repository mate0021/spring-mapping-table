package rnd.mate00.springmappingtable.entity.orderservice;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String address;
    private String city;
    private String postalCode;

    public Address() {
    }

    public Address(String address, String city, String postalCode) {
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address1 = (Address) o;
        return Objects.equals(getAddress(), address1.getAddress()) && Objects.equals(getCity(), address1.getCity()) && Objects.equals(getPostalCode(), address1.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getCity(), getPostalCode());
    }
}

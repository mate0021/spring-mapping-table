package rnd.mate00.springmappingtable.entity.orderservice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@AttributeOverrides({
        @AttributeOverride(name = "address.address", column = @Column(name = "address")),
        @AttributeOverride(name = "address.city", column = @Column(name = "city")),
        @AttributeOverride(name = "address.postalCode", column = @Column(name = "postal_code"))
})
public class Customer extends BaseEntity {

    private String customerName;

    @Embedded
    private Address address;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<OrderHeader> orderHeader = new HashSet<>();

    @Version
    private int version;


    public Customer() {
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Customer(String customerName, Address address, String phone, String email) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderHeader> getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(Set<OrderHeader> orderHeader) {
        this.orderHeader = orderHeader;
    }

    public void addOrderHeader(OrderHeader orderHeader) {
        this.orderHeader.add(orderHeader);
        orderHeader.setCustomer(this);
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                "customerName='" + customerName + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", orderHeader=" + orderHeader +
                '}';
    }
}

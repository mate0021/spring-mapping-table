package rnd.mate00.springmappingtable.entity.orderservice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "orderHeader", cascade = CascadeType.PERSIST)
    private Set<OrderLine> orderLines = new HashSet<>();

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "orderHeader")
    private OrderApproval orderApproval;

    @Version
    private int version;


    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
        orderLine.setOrderHeader(this);
    }

    public OrderHeader() {
    }

    public OrderHeader(String customer, Address shippingAddress, Address billingAddress, OrderStatus orderStatus) {
        this(new Customer(customer), shippingAddress, billingAddress, orderStatus);
    }

    public OrderHeader(Customer customer, Address shippingAddress, Address billingAddress, OrderStatus orderStatus) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public OrderApproval getOrderApproval() {
        return orderApproval;
    }

    public void setOrderApproval(OrderApproval orderApproval) {
        this.orderApproval = orderApproval;
        orderApproval.setOrderHeader(this);
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderHeader)) return false;
        if (!super.equals(o)) return false;
        OrderHeader that = (OrderHeader) o;
        return Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getShippingAddress(), that.getShippingAddress()) && Objects.equals(getBillingAddress(), that.getBillingAddress()) && getOrderStatus() == that.getOrderStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCustomer(), getShippingAddress(), getBillingAddress(), getOrderStatus());
    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "customer=" + customer +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                ", orderStatus=" + orderStatus +
                ", orderLines=" + orderLines +
                ", orderApproval=" + orderApproval +
                '}';
    }
}

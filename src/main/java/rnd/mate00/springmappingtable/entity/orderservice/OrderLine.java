package rnd.mate00.springmappingtable.entity.orderservice;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Objects;

@Entity
@Table(name = "order_line")
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;

    @ManyToOne
    private OrderHeader orderHeader;

    @ManyToOne
    private Product product;

    @Version
    private int version;


    public OrderLine() {
    }

    public OrderLine(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(o instanceof OrderLine)) return false;
        if (!super.equals(o)) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(getQuantityOrdered(), orderLine.getQuantityOrdered()) && Objects.equals(getOrderHeader(), orderLine.getOrderHeader());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQuantityOrdered(), getOrderHeader());
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "quantityOrdered=" + quantityOrdered +
                ", orderHeader=" + orderHeader +
                ", product=" + product +
                '}';
    }
}

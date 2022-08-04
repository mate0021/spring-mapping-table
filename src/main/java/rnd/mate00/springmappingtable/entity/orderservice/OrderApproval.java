package rnd.mate00.springmappingtable.entity.orderservice;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_approval")
public class OrderApproval extends BaseEntity {

    private String approvedBy;

    @OneToOne
    @JoinColumn(name = "order_header_id")
    private OrderHeader orderHeader;


    public OrderApproval() {
    }

    public OrderApproval(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }

    @Override
    public String toString() {
        return "OrderApproval{" +
                "approvedBy='" + approvedBy + '\'' +
                ", orderHeader=" + orderHeader +
                '}';
    }
}

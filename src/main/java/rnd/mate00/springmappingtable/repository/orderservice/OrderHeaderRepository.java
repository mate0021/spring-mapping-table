package rnd.mate00.springmappingtable.repository.orderservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.orderservice.OrderHeader;

@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
}

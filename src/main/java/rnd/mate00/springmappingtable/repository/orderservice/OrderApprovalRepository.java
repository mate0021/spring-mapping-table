package rnd.mate00.springmappingtable.repository.orderservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.orderservice.OrderApproval;

import java.util.Optional;

@Repository
public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {

    Optional<OrderApproval> findByApprovedBy(String approvedBy);
}

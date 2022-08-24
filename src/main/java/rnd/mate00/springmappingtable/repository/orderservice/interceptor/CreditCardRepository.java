package rnd.mate00.springmappingtable.repository.orderservice.interceptor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.interceptor.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

    CreditCard findFirstByHolderName(String holderName);
}

package rnd.mate00.springmappingtable.entity.interceptor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String holderName;

    @Column
    private String creditCardNumber;

    @Column
    private String expiryDate;
}

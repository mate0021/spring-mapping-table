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

    @Encrypted
    @Column
    private String creditCardNumber;

    @Column
    private String expiryDate;


    public CreditCard() {
    }

    public CreditCard(String holderName, String creditCardNumber, String expiryDate) {
        this.holderName = holderName;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", holderName='" + holderName + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
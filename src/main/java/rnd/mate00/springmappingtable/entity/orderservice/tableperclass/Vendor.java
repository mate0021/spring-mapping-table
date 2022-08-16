package rnd.mate00.springmappingtable.entity.orderservice.tableperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)    // <- otherwise - 'Cannot use identity column with union-subclass'
                                                        // also, hibernate_sequenceS table is needed
    private int id;

    private String vendorName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}

package rnd.mate00.springmappingtable.entity.orderservice.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hardware_vendor")
public class HardwareVendor extends Vendor {

    private String typeOfChip;

    public String getTypeOfChip() {
        return typeOfChip;
    }

    public void setTypeOfChip(String typeOfChip) {
        this.typeOfChip = typeOfChip;
    }
}

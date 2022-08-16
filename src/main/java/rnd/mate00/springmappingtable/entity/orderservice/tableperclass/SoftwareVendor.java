package rnd.mate00.springmappingtable.entity.orderservice.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "software_vendor")
public class SoftwareVendor extends Vendor {

    private String languageUsed;

    public String getLanguageUsed() {
        return languageUsed;
    }

    public void setLanguageUsed(String languageUsed) {
        this.languageUsed = languageUsed;
    }
}

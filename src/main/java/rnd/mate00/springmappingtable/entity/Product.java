package rnd.mate00.springmappingtable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    @OneToMany
    private List<Region> regions;

    @OneToMany
    private List<Country> countries;

    @OneToMany
    private List<Office> offices;
}

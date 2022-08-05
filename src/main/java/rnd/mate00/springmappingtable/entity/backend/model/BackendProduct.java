package rnd.mate00.springmappingtable.entity.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rnd.mate00.springmappingtable.entity.backend.model.location.BackendRegion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bb_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BackendProduct {

    @Id
    private int productId;

    private String productName;

    private int jobId;

    @OneToMany
    private Set<BackendRegion> regions = new HashSet<>();
}
/*
anyways, this table is necessary
mysql> describe bb_product_regions;
        +----------------------------+------+------+-----+---------+-------+
        | Field                      | Type | Null | Key | Default | Extra |
        +----------------------------+------+------+-----+---------+-------+
        | backend_product_product_id | int  | YES  |     | NULL    |       |
        | regions_product_id         | int  | YES  |     | NULL    |       |
        | regions_region_id          | int  | YES  |     | NULL    |       |
        | job_id                     | int  | YES  |     | NULL    |       |
        +----------------------------+------+------+-----+---------+-------+
 */
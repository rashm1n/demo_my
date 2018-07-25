package it.codegen.rnd.assetTracking.dbModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assetCatagory")
public class AssetCatagory {

    @Id
    @Column(name = "catagoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;

    @Column(name = "catagoryName",unique = true)
    private String name = null;

    @OneToMany(mappedBy = "assetCatagory")
    private List<Asset> assets = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

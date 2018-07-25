package it.codegen.rnd.assetTracking.dbModels;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @Column(name = "assetID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;

    @Column(name = "assetName")
    private String name = null;

    @Column(name = "aquiredDate")
    private Date aquiredDate = null;

    @Column(name = "occupiedStatus")
    private Boolean status = null;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationID")
    private Location location = null;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catagoryID")
    private AssetCatagory assetCatagory = null;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeID")
    private Employee employee = null;

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

    public Date getAquiredDate() {
        return aquiredDate;
    }

    public void setAquiredDate(Date aquiredDate) {
        this.aquiredDate = aquiredDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean b) {
        this.status = b;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AssetCatagory getAssetCatagory() {
        return assetCatagory;
    }

    public void setAssetCatagory(AssetCatagory assetCatagory) {
        this.assetCatagory = assetCatagory;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

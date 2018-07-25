package it.codegen.rnd.assetTracking.dbModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employeeID",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;

    @Column(name = "employeeName")
    private String name = null;

    @Column(name = "assognedProject")
    private String project = null;

    @Column(name = "age")
    private int age = 0;

    @OneToMany(mappedBy = "employee")
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

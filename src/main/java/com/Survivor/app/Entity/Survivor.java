package com.Survivor.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Survivor")
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(nullable = false))
    })
    private Location lastlocation;

    @Embedded
    private Resource resource;

    @Column(name = "status", nullable = false)
    private boolean infectedStatus;

    @Transient
    private int contaminationReports=0;

    public Survivor() {
        //this.contaminationReports = 0;
    }

    //public Survivor(boolean infectedStatus) {
      //  this.infectedStatus = infectedStatus;
       // this.contaminationReports = 0;
    //}

    // Constructor without id parameter to avoid confusion with auto-generated ids
    public Survivor(String name, int age, String gender, Location lastlocation, Resource resource,int contaminationReports) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.lastlocation = lastlocation;
        this.resource = resource;
        this.contaminationReports = contaminationReports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Location getLastlocation() {
        return lastlocation;
    }

    public void setLastlocation(Location lastlocation) {
        this.lastlocation = lastlocation;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public boolean isInfectedStatus() {
        return infectedStatus;
    }

    public void setInfectedStatus(boolean infectedStatus) {
        this.infectedStatus = infectedStatus;
    }

    public int getContaminationReports() {
        return contaminationReports;
    }

    public void reportContamination() {
        System.out.println(contaminationReports);
        this.contaminationReports++;
        System.out.println(contaminationReports);
        if (this.contaminationReports >= 3) {
            this.infectedStatus = true;
        }
    }
}

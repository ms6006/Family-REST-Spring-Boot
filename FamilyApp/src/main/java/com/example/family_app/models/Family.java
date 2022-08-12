package com.example.family_app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("family")
public class Family {

    @Id
    private int id;

    private String familyName;
    private int nrOfAdults, nrOfChildren, nrOfInfants;

    public Family(){

    }

    public Family(String familyName, int nrOfAdults, int nrOfChildren, int nrOfInfants) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(int nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public int getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(int nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", nrOfAdults=" + nrOfAdults +
                ", nrOfChildren=" + nrOfChildren +
                ", nrOfInfants=" + nrOfInfants +
                '}';
    }
}

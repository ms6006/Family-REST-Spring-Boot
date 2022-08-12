package com.example.FamilyMemberApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("family_member")
public class FamilyMember {

    @Id
    private int id;

    private String familyName, givenName;
    private int familyId;
    private int age;

    public FamilyMember(){

    }

    public FamilyMember(String familyName, String givenName, int familyId, int age) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.familyId = familyId;
        this.age = age;
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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

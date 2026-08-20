package com.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dateOfBirth;
    private String gender;
    private String bloodGroup;

    // No-Argument Constructor
    public StudentProfile() {
    }

    // Parameterized Constructor
    public StudentProfile(String dateOfBirth, String gender, String bloodGroup) {
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for dateOfBirth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter for dateOfBirth
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter for bloodGroup
    public String getBloodGroup() {
        return bloodGroup;
    }

    // Setter for bloodGroup
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "StudentProfile [id=" + id
                + ", dateOfBirth=" + dateOfBirth
                + ", gender=" + gender
                + ", bloodGroup=" + bloodGroup
                + "]";
    }
}
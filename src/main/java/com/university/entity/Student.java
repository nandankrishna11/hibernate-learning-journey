package com.university.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String course;


    // =========================
    // Embedded Address
    // =========================

    @Embedded
    private Address address;


    // =========================
    // Element Collection
    // =========================

    @ElementCollection
    @CollectionTable(
        name = "student_phone_numbers",
        joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "phone_number")
    private List<String> phoneNumbers = new ArrayList<>();


    // =========================
    // Many Students -> One Department
    // =========================

    @ManyToOne
    private Department department;


    // =========================
    // One Student -> One Profile
    // =========================

    @OneToOne
    @JoinColumn(name = "profile_id")
    private StudentProfile profile;


    // =========================
    // Constructors
    // =========================

    // No-Argument Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(
            String name,
            String email,
            String course,
            Address address,
            Department department,
            StudentProfile profile) {

        this.name = name;
        this.email = email;
        this.course = course;
        this.address = address;
        this.department = department;
        this.profile = profile;
    }


    // =========================
    // Getters and Setters
    // =========================

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }


    // =========================
    // toString()
    // =========================

    @Override
    public String toString() {
        return "Student [id=" + id
                + ", name=" + name
                + ", email=" + email
                + ", course=" + course
                + ", address=" + address
                + ", phoneNumbers=" + phoneNumbers
                + ", department=" + department
                + ", profile=" + profile
                + "]";
    }
}
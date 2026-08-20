//many to one


package com.university.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Address;
import com.university.entity.Department;
import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class SaveStudentWithDepartment {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        // Create Department
        Department department = new Department("Computer Science");

        // Create Address
        Address address = new Address(
                "BTM Layout",
                "Bangalore",
                "Karnataka",
                "560001"
        );

        // Create Student
        Student student = new Student(
                "Arun",
                "arun123@gmail.com",
                "B.Tech",
                address,
                department
        );

        // Add phone numbers
        student.getPhoneNumbers().add("9876543210");
        student.getPhoneNumbers().add("9123456780");

        // Save Department first
        session.persist(department);

        // Save Student
        session.persist(student);

        transaction.commit();

        session.close();

        System.out.println("Student and Department saved successfully!");
    }
}
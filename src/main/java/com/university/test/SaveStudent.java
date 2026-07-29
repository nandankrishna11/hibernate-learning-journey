package com.university.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class SaveStudent {

    public static void main(String[] args) {

        // Create Student object
        Student student = new Student(
                "Nandan",
                "nandan@gmail.com",
                "MCA");

        // Open Session
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Save Student
        session.persist(student);

        // Commit Transaction
        transaction.commit();

        // Close Session
        session.close();

        System.out.println("Student saved successfully!");
    }
}
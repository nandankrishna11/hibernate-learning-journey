package com.university.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class UpdateStudent {

    public static void main(String[] args) {

        // Open Session
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Fetch Student
        Student student = session.get(Student.class, 1);

        if (student != null) {

            // Modify Object
            student.setCourse("MCA");
            

            // Commit Transaction
            transaction.commit();

            System.out.println("Student updated successfully.");

        } else {

            System.out.println("Student not found.");

        }

        // Close Session
        session.close();
    }
}
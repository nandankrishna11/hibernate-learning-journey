package com.university.test;

import org.hibernate.Session;

import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class GetStudent {

    public static void main(String[] args) {

        // Open Session
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        // Retrieve Student with ID = 1
        Student student = session.get(Student.class, 5);

        // Check if found
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }

        // Close Session
        session.close();
    }
}
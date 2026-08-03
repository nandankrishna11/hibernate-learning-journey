package com.university.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class DeleteStudent {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, 1);

        if (student != null) {

            session.remove(student);

            transaction.commit();

            System.out.println("Student deleted successfully.");

        } else {

            System.out.println("Student not found.");

        }

        session.close();
    }
}
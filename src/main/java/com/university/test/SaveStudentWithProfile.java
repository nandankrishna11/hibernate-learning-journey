package com.university.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Department;
import com.university.entity.Student;
import com.university.entity.StudentProfile;
import com.university.util.HibernateUtil;

public class SaveStudentWithProfile {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        // Create Department
        Department department =
                new Department("Information Technology");

        // Create Student Profile
        StudentProfile profile =
                new StudentProfile(
                        "15-08-2003",
                        "Male",
                        "O+"
                );

        // Create Student
        Student student =
                new Student(
                        "Vivek",
                        "vivek123@gmail.com",
                        "B.Tech",
                        null,
                        department,
                        profile
                );

        // Save Department
        session.persist(department);

        // Save Profile
        session.persist(profile);

        // Save Student
        session.persist(student);

        transaction.commit();

        session.close();

        System.out.println("Student with profile saved successfully!");
    }
}
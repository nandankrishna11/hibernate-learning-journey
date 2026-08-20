package com.university.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Department;
import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class SaveDepartmentWithStudents {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        Department department =
                new Department("Mechanical Engineering");

        Student student1 =
                new Student(
                        "John",
                        "john_Mech@gmail.com",
                        "B.Tech",
                        null,
                        department
                );

        Student student2 =
                new Student(
                        "Rahul",
                        "rahul_mech@gmail.com",
                        "B.Tech",
                        null,
                        department
                );

        // Owning side
        student1.setDepartment(department);
        student2.setDepartment(department);

        session.persist(department);
        session.persist(student1);
        session.persist(student2);

        transaction.commit();

        session.close();

        System.out.println("Department and students saved successfully!");
    }
}
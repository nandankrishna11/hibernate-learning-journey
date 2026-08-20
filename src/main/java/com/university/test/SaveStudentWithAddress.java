package com.university.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.university.entity.Address;
import com.university.entity.Student;
import com.university.util.HibernateUtil;

public class SaveStudentWithAddress {

    public static void main(String[] args) {

        Address address = new Address(
                "BTM Layout",
                "Bangalore",
                "India",
                "987632"
        );

        Student student = new Student(
        	    "sanman",
        	    "sanmanl123@gmail.com",
        	    "MCA",
        	    address
        	);

        	student.getPhoneNumbers().add("9876543210");
        	student.getPhoneNumbers().add("9123456780");
        	student.getPhoneNumbers().add("8899776655");
        Session s1 = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction t = s1.beginTransaction();

        s1.persist(student);

        t.commit();

        s1.close();

        System.out.println("Student with address saved successfully!");
    }
}
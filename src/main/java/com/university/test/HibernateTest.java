package com.university.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.university.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("Hibernate connected successfully!");
		session.close();
		sessionFactory.close();

	}

}

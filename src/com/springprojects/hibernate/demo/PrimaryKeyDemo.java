package com.springprojects.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springprojects.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student object
			System.out.println("Creating a new student objects...");
			Student tempStudent1 = new Student("Varsha", "Mehta", "queeny@spring.com");
			Student tempStudent2 = new Student("Monika", "Tarawat", "monika@spring.com");
			Student tempStudent3 = new Student("Rachit", "Modi", "rachit@yahoo.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} 
		finally {
			factory.close();

		}

	}

}

package com.springprojects.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springprojects.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
		                        .addAnnotatedClass(Student.class)
		                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudent);
			
			//query students: lastName = 'Modi'
			theStudent = session.createQuery("from Student s where s.lastName = 'Modi'").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who have last name Modi ");
			displayStudents(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
			
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}











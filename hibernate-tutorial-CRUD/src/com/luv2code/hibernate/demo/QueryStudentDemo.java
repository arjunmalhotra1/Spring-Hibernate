package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class QueryStudentDemo { 

	public static void main(String[] args) {
	
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//Create session
		Session session=factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//Query Students
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			
			//Display all the Students
			displayStudents(theStudents);
			
			
			//Query Students and find all students whose last name ins ='Doe'
			theStudents=session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display the students with last name as "Doe"
			System.out.println("\n \nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			
			//Query Students: Last name is 'Doe' OR firstName='Daffy'
			
			theStudents=session.createQuery("from Student s where"
										+" s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			//display the students with last name as "Doe" Or First name 'Daffy'
			System.out.println("\n \nStudents who have last name of Doe or first name Daffy");
			displayStudents(theStudents);
			
			//Query Using the LIKE clause in HQL. Query students with email like '%luv2code.com'
			theStudents=session.createQuery("from Student s where"
											+" s.email LIKE '%luv2code.com'").getResultList();
			
			//display the students with email ends with luv2code.com
			System.out.println("\n \nStudents who have email that ends with luv2code.com");
			displayStudents(theStudents);
			
			
			
			//Query Using the LIKE clause in HQL. Query students with email like '%gmail.com'
			theStudents=session.createQuery("from Student s where"
											+" s.email LIKE '%gmail.com'").getResultList();
			
			//display the students with email ends with gmail.com
			System.out.println("\n \nStudents who have email that ends with luv2code.com");
			displayStudents(theStudents);
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}

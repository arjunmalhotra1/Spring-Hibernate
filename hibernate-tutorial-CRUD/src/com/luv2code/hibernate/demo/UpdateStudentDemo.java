package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo { 

	public static void main(String[] args) {
	
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//Create session
		Session session=factory.getCurrentSession();
		
		
		try {
			
			int studentId=1;
			
			//Now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			
			//Retrieve the student based on the id"primary key
			System.out.println("\n \nGetting student with id "+studentId);
			Student myStudent=session.get(Student.class, studentId);
			//System.out.println("Get complete: "+myStudent);
			
			//Updating the student just one update
			System.out.println("Updating the student...");
			myStudent.setFirstName("Scooby");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			//Update the bulk Students
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Update the email for all the students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'")
			.executeUpdate();
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}

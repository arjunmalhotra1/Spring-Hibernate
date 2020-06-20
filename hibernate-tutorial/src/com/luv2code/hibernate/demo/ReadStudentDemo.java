package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo { 

	public static void main(String[] args) {
	
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//Create session
		Session session=factory.getCurrentSession();
		
		
		try {
			//create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent=new Student("Daffy","Duck","daffy@luv2code.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//My new Code
			//find out Student's id:primary key
			System.out.println("Saved student Generated id: "+tempStudent.getId()); 
			
			
			//Now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			
			//Retrieve the student based on the id"primary key
			System.out.println("\n \nGetting student with id "+tempStudent.getId());
			Student myStudent=session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			 
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}

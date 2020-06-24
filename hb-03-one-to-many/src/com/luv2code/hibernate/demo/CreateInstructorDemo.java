package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo { 

	public static void main(String[] args) {
	
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		
		//Create session
		Session session=factory.getCurrentSession();
		
		
		try {
			
			//create our objects
			Instructor tempInstructor=new Instructor("john","doe","johndoe@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("youtube.com","loves to play guitar");
			
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			
			//save the instructor
			//
			// Note: This will ALSO save the InstructorDetails object because of CascadeType.ALL
			//
			//
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			factory.close();
		}

	}

}

package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo { 

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
			
			//start a transaction
			session.beginTransaction();
			
			//Get the instructor from the Database
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class,theId);
			
			System.out.println("Instructor: "+tempInstructor);

			//Get the courses for the Instructor
			System.out.println("Courses "+tempInstructor.getCourses()); 
			tempInstructor.getCourses();
			
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

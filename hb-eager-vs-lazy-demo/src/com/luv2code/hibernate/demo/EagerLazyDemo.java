package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo { 

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
			//At this point because of the Eager loading, Instructor, InstructorDetails and Courses are all loaded.
			
			System.out.println("luv2code: Instructor: "+tempInstructor); //Toggle breakpoint here, Eclipse will stop the execution here.
			System.out.println("luv2code: Courses "+tempInstructor.getCourses());

			//commit transaction
			session.getTransaction().commit();
			
			//Closing the session to see if the Lazy loading breaks/fails
			session.close();
			
			System.out.println("luv2code: The session is not closed! \n");
			//Option 1: Call the getter method while the session in open.
			//Get the courses for the Instructor//In case of the Lazy Loading the courses are loaded only on demand.
			System.out.println("luv2code: Courses "+tempInstructor.getCourses()); 
			
			System.out.println("luv2code: Done!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			factory.close();
		}

	}

}

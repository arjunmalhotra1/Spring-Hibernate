package com.luv2code.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo { 

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
			
			//Option 2: Hibernate query with HQL
			//Get the instructor from the Database
			int theId=1;
			Query<Instructor> query= session.createQuery("select i from Instructor i "
														+"JOIN FETCH i.courses "
														+ "where i.id=:theInstructorId",
														Instructor.class);
					
			//set parameter on query
			query.setParameter("theInstructorId", theId);
		
			//Execute the query. This will load the instructor and the courses all at once.
			Instructor tempInstructor=query.getSingleResult();
			
			System.out.println("luv2code: Instructor: "+tempInstructor);

			//commit transaction
			session.getTransaction().commit();
			
			//Closing the session to see if the Lazy loading breaks/fails
			session.close();
			
			System.out.println("luv2code: The session is not closed! \n");
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

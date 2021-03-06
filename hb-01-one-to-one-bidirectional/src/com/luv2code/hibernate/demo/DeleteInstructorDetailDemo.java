package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo { 

	public static void main(String[] args) {
	
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		//Create session
		Session session=factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId=5;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			
			//Print the Instructor Detail
			System.out.println("tempInstructorDetail "+tempInstructorDetail);
			
			//Print the Instructor
			System.out.println("the associated instructor "+tempInstructorDetail.getInstructor());
			
			//Now let's delete the InstructorDetail This will delete the Instructor entry as we have Cascade type of Delete.all
			System.out.println("Deleteing tempInstructorDetail: "+tempInstructorDetail);
			
			//Delete the associated object reference
			//break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally 
		{
			//handle connection leak
			session.close();
			factory.close();
		}

	}

}

package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
//import com.mysql.cj.Session;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		//Create Sessions
		Session session=factory.getCurrentSession();
		
		try {
			//create employee object
			Employee emp=new Employee("daffy","duck","Warner brothers");
			
			// start transaction
			session.beginTransaction();
			
			//save the employee object
			session.save(emp);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}

package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) 
	{
		
		//Load the Spring Configuration File
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean from the Spring container
		CricketCoach theCoach=context.getBean("myCricketCoach",CricketCoach.class);
		
		//Call methods on the bean
		System.out.println(theCoach.getFortune());
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		//close the context
		context.close();
	}

}

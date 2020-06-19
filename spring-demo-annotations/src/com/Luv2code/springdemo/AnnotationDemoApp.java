package com.Luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//Read the Spring config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from the spring container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		//Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call the method to get the DailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
		

	}

}

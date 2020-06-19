package com.Luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Read the Spring config Java file
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container
		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		
		//Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call the method to get the DailyFortune
		System.out.println(theCoach.getDailyFortune());
		
		
		//call our new swim coach methods ... has the props values injected
		System.out.println("email: "+theCoach.getEmail());
		System.out.println("team: "+theCoach.getTeam());
		
		
		//close the context
		context.close();
		
		
		

	}

}

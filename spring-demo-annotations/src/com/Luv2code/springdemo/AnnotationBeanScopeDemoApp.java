package com.Luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//Load the Spring Configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean from the Spring Container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
				
		//Check if they are the same
		boolean result=(theCoach==alphaCoach);
		
		//print out the result
		System.out.println("\n pointing to the same object "+result);
		
		System.out.println("\n Memory Location of theCoach "+theCoach);
		
		System.out.println("\n Memory Location of alphCoach "+alphaCoach);
				
		//Closing the context
		context.close();

	}

}

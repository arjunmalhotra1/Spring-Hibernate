package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//Load the Spring Configuration File
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//Retrieve Bean from the Spring Container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
		//check if these 2 beans are the same
		boolean result=(theCoach==alphaCoach);
		
		System.out.println("Pointing to the same object "+result);
		System.out.println("Memory Location for theCoach"+theCoach);
		System.out.println("Memory Location for alphaCoach"+alphaCoach);
		context.close();
		
	}

}

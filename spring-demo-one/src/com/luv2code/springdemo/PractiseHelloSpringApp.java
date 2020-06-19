package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PractiseHelloSpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myGolfCoach=context.getBean("mygolfcoach",GolfCoach.class);
		
		System.out.println(myGolfCoach.getFortune());
		System.out.println(myGolfCoach.getDailyWorkout());
		context.close();

	}

}

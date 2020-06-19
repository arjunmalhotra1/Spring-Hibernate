package com.Luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// Default constructor
	public TennisCoach() {
		System.out.println("Tennis Coach inside default Constructor");
	}
	
	
	//define init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(">> Tennis Coach: inside doMyStartupStuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupupStuff()
	{
		System.out.println(">> Tennis Coach: inside doMyCleanupupStuff");
	}
	
	
	// define a setter method
	/*
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println("TennisCoach: Inside setFortuneService() method");
	 * fortuneService = theFortuneService; }
	 */

	/*
	 * @Autowired public TennisCoach(FortuneService thefortuneService) {
	 * fortuneService=thefortuneService; }
	 */

	
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * System.out.println("TennisCoach: Inside doSomeCrazyStuff() method");
	 * fortuneService = theFortuneService; }
	 */
		 
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}

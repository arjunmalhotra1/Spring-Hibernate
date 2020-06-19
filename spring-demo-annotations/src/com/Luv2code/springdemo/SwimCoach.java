package com.Luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	
	/*
	 * @Autowired
	 * 
	 * @Qualifier("sadFortuneService") FortuneService fortuneService;
	 */
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	 private FortuneService fortuneService;
	
	 public SwimCoach(FortuneService theFortuneService) {
	 fortuneService=theFortuneService; }
 
	
	public SwimCoach() {}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meteres as a warmup";
	}

	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

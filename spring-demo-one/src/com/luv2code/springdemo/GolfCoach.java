package com.luv2code.springdemo;

public class GolfCoach implements Coach {

	FortuneService fortuneService;
	
	
	
	public GolfCoach(FortuneService fortune)
	{
		fortuneService=fortune;
	}
	
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice putting";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}

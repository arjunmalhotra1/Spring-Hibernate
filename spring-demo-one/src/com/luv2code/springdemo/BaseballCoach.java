package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService thefortuneService)
	{
		fortuneService=thefortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practise"; 
	}

	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}
	
	

}

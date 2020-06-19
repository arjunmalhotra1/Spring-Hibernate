package com.luv2code.springdemo;

public class Trackcoach implements Coach {

	private FortuneService fortuneService;
	
	
	
	
	public Trackcoach(FortuneService fortuneService) {
		//super();
		System.out.println("Inside TrackCoach's fortuneservice constructor");
		this.fortuneService = fortuneService;
	}
	
	public Trackcoach() {
	}

	
	@Override
	public String getDailyWorkout() 
	{
		return "run a hard 5k";
	}

	@Override
	public String getFortune() 
	{
		return "Just do it "+fortuneService.getFortune();
	}
	
	public void doMyStartupStuff()
	{
		System.out.println("TrackCoach: Inside the method doMyStartupStuff");
	}
	
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: Inside the method doMyCleanupStuffYoYo");
	}

}

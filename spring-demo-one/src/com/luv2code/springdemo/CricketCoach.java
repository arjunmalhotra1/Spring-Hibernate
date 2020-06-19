package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	//no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}
	
	//Our Setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach, Inside setter moethod of - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		
		return "Practise bowling for 15 mins";
	}

	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}

	

}

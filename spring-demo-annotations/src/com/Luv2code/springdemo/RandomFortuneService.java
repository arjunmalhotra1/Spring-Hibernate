package com.Luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data= {
			"Beware fo wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	//Create a random number generator
	private Random myRandom=new Random();

	@Override
	public String getFortune() {
		int index=myRandom.nextInt(data.length);
		
		String theFortune=data[index];
		
		return theFortune;
	}

}

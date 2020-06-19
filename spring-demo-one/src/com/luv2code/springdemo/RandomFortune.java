package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService {

	String[] fortunes={"random 1","random 2","random 3"};
	
	private Random myrandom=new Random();
	
	@Override
	public String getFortune() {
		
		int index=myrandom.nextInt(fortunes.length);
		return fortunes[index];
		
	}

}

package com.Luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	
	//Define Bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}
	
	//Define bean for our swim coach and inject dependedncy
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
		//return new SwimCoach();
	}
	
}

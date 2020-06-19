package com.Luv2code.springdemo;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private String filepath="C:\\Users\\Arjun\\eclipse-workspace_Javaweb\\spring-demo-annotations\\src\\fortune-data";
	
	private Random myrandom=new Random();
	
	private List<String> theFortunes;
	
	public FileFortuneService()
	{
		File theFile=new File(filepath);
		
		System.out.println("Reading fiole from "+theFile);
		System.out.println("Fist exists: "+theFile.exists());
		theFortunes=new ArrayList<String>();	
		
		try(BufferedReader br=new BufferedReader(new FileReader(theFile)))
		{
			String tempLine;
			while((tempLine=br.readLine())!=null) 
			{
				theFortunes.add(tempLine);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() 
	{
		int index=myrandom.nextInt(theFortunes.size());
		return theFortunes.get(index);
	}

}

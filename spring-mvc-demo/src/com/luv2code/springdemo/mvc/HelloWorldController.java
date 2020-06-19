package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	
	//Need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	
	//Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//Need a new controller method to read from data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutdude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String theName=request.getParameter("studentName");
		
		//Covert the data to all upper case
		theName=theName.toUpperCase();
		
		// Create the message
		String result="Yo! "+theName;
		
		//Add message to the model
		model.addAttribute("message",result);//Adding data to the model
		
		
		return "helloworld";
		
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//Covert the data to all upper case
		theName=theName.toUpperCase();
		
		// Create the message
		String result="Hey my Frind from v3!  "+theName;
		
		//Add message to the model
		model.addAttribute("message",result);//Adding data to the model
		
		
		return "helloworld";
		
	}
	
	
	


}

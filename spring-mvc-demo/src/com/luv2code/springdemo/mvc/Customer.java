package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	
	private String firstName;
	
	
	@NotNull(message="Required is field, Cannot be not null")
	@Size(min=1,message="Required field")
	private String lastName;
	
	@NotNull(message="Field is rquired")
	@Min(value=0,message="Must be greater than or equal to 0")
	@Max(value=10,message="Must be less than or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="Only 5 chars/digits")
	private String postalCode;
	
	
	@CourseCode(value="TOPS",message="must start with")
	private String courseCode;
	
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
	
	

}

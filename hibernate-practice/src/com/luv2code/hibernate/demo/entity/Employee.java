package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="company")
	private String company;
	
	public Employee( String firstName, String lastName, String company) 
	{
		
		this.firstName = firstName;
		LastName = lastName;
		this.company = company;
	}

	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", company=" + company
				+ "]";
	}


	public Employee()
	{
		
	}

}

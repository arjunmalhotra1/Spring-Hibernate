package com.luv2code.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestingJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		
		
		try {
			
			System.out.println("Connecting to the database "+jdbcUrl);
			
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful !!!");
			
			
					
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

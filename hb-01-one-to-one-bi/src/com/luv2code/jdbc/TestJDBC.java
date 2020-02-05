package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl ="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
		String userName="hbstudent";
		String passWord="hbstudent";
		try {
			System.out.println("Connecting to database");
			Connection myconn= DriverManager.getConnection(jdbcUrl,userName,passWord);
			System.out.println("connection success");
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

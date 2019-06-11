package com.timesheet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl="jdbc:mysql://localhost:3306/timesheet?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="";
		try {
			Connection conn= DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successful!!!");
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

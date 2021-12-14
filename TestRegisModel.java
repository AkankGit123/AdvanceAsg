package com.rays.servletJ;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestRegisModel {
	
	public static com.mysql.jdbc.Connection add() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		return (com.mysql.jdbc.Connection) conn;
		 
	}

}

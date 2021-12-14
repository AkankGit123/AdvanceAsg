package com.rays.servletJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthModel {
	
	public AuthBean authC(String email, String pwd) {
		
		AuthBean bean=null;
		try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	PreparedStatement ps = conn.prepareStatement("SELECT * FROM registerform WHERE email=? and pwd = ?");
	ps.setString(1, email);
	ps.setString(2, pwd);
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		bean= new AuthBean();
		bean.setEmail(rs.getString(1));
		bean.setPwd(rs.getString(2));
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return bean;
		}
	
}

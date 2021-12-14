package com.rays.servletJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;


public class RegistrationModel {
	
	
	public AuthBean authC(String email, String pwd) {
		
		AuthBean bean=null;
		try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	PreparedStatement ps = conn.prepareStatement("SELECT fname,pwd FROM registerform WHERE email=? and pwd = ?");
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

public String add(RegistrationBean bean) throws Exception {
		String status;
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO registerform VALUES(?,?,?,?,?,?,?)");
		ps.setString(1, bean.getFname());
		ps.setString(2, bean.getLname());
		ps.setString(3, bean.getGender());
		ps.setString(4, bean.getDob());
		ps.setString(5, bean.getAdd());
		ps.setString(6, bean.getEmail());
		ps.setString(7, bean.getPwd());
		
		
		int i = ps.executeUpdate();
		ps.close();
		conn.close();
		
		if(i==1) {
			status="success";
		}else {
			status="fail";
		}
		return status;
		
		
		 
	}


public RegistrationBean Regis(String login , String pwd) throws Exception {
	
	RegistrationBean bean = null;

	Class.forName("com.mysql.jdbc.Driver");

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
	PreparedStatement ps = conn.prepareStatement("SELECT email,pwd,fname FROM registerform WHERE email=? AND pwd=? ");
	ps.setString(1, login);
	ps.setString(2, pwd);
	ResultSet rs=ps.executeQuery();
    while (rs.next()) {
		bean=new RegistrationBean();
		bean.setEmail(rs.getString(1));
		bean.setPwd(rs.getString(2));
		bean.setFname(rs.getString(3));
    }
	ps.close();
	conn.close();
	return bean;
}


public RegistrationBean forgetPwd(String login) throws Exception {
	RegistrationBean bean =null; 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	PreparedStatement ps = conn.prepareStatement("Select pwd from registerform where email=?");
	
	ps.setString(1, login);
	ResultSet rs = ps.executeQuery();while(rs.next()) {
		bean= new RegistrationBean();
		bean.setPwd(rs.getString(1));
	}
	
	ps.close();
	conn.close();
	return bean;
	
}


public RegistrationBean getFirstnameofUser(String login) throws Exception {
	RegistrationBean bean =null; 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	PreparedStatement ps = conn.prepareStatement("Select fname from registerform where email=?");
	ps.setString(1, login);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		bean= new RegistrationBean();
		bean.setFname(rs.getString(1));
	}	
	ps.close();
	conn.close();	
	return bean;
	
}


}

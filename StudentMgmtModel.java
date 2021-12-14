package com.rays.servletJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentMgmtModel {

	
	public static void add(StudentMgmtBean bn) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		
		PreparedStatement ps = conn.prepareStatement("Insert into stdntmgmt values(?,?,?,?,?)");
		
		ps.setInt(1, bn.getId());
		ps.setString(2, bn.getRollNo());
		ps.setString(3, bn.getFirstName());
		ps.setString(4, bn.getLastName());
		ps.setString(5, bn.getSession());
		int i =ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	
	public static void delete(StudentMgmtBean bn) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		
		PreparedStatement ps = conn.prepareStatement("Delete from stdntmgmt where id=?");
		
		ps.setInt(1, bn.getId());
		ps.execute();
		ps.close();
		conn.close();
	}
	
	public static void modify(StudentMgmtBean bn) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		
		PreparedStatement ps = conn.prepareStatement("Update stdntmgmt Set rollNo=?,firstName=?,lastName=?,session=? where id=?");
		ps.setString(1, bn.getRollNo());
		ps.setString(2, bn.getFirstName());
		ps.setString(3, bn.getLastName());
		ps.setString(4, bn.getSession());
		ps.setInt(5, bn.getId());
		
		ps.execute();
		ps.close();
		conn.close();
	}
	
	public StudentMgmtBean getRollNo(String rollNo) throws Exception {
		StudentMgmtBean bn = new StudentMgmtBean();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		
		PreparedStatement ps = conn.prepareStatement("Select id,firstName,lastName,session from stdntmgmt where rollNo = ?");
		
		ps.setString(1, rollNo);
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			bn.setId(rs.getInt(1));
			bn.setFirstName(rs.getString(2));
			bn.setLastName(rs.getString(3));
			bn.setSession(rs.getString(4));
		}
		return bn;
	}
	
	
	  public ArrayList<StudentMgmtBean> StudentList() throws Exception {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root",
	  "root"); 
	  PreparedStatement ps = conn.prepareStatement("Select * from stdntmgmt"); ResultSet rs =
	  ps.executeQuery();
	  ArrayList<StudentMgmtBean> listB = new ArrayList<StudentMgmtBean>();
	  while(rs.next()) {
		  StudentMgmtBean bn = new StudentMgmtBean(); 
		  bn.setId(rs.getInt(1));
		  bn.setRollNo(rs.getString(2));
	  bn.setFirstName(rs.getString(3));
	  bn.setLastName(rs.getString(4));
	  bn.setSession(rs.getString(5));
	  listB.add(bn);
	  } 
	  return listB;
	  }
	 
	
	

}

package com.rays.servletJ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/TestRegiCTL")
public class TestRegiCTL extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			Connection conn = TestRegisModel.add();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO testreg VALUES(?,?)");
			ps.setInt(1, Integer.valueOf(request.getParameter("id")));
			ps.setString(2, request.getParameter("nm"));
			ps.executeUpdate();
			ps.close();
			conn.close();
			
			PrintWriter out = response.getWriter();
			out.println("Inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}

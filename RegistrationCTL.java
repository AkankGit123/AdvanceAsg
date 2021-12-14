package com.rays.servletJ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationCTL")
public class RegistrationCTL extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String add = request.getParameter("add");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
	
			RegistrationModel model = new RegistrationModel();
			RegistrationBean bean = new RegistrationBean();
			bean.setFname(fname);
			bean.setLname(lname);
			bean.setGender(gender);
			bean.setDob(dob);
			bean.setAdd(add);
			bean.setEmail(email);
			bean.setPwd(pwd);
			boolean pass = true;
			
			if (DataValidator.isNull(fname)) {
				request.setAttribute("error1", "Enter name");
				pass = false;
			} else if (!DataValidator.isName(fname)) {
				request.setAttribute("error2", "Name must contain only Characters ");
				pass = false;
			} else if (DataValidator.isNull(request.getParameter("lname"))) {
				request.setAttribute("error3", "Enter Surname");
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("lname"))) {
				request.setAttribute("error4", "SurName must contain only Characters ");
				pass = false;
			} else if (DataValidator.isNull(request.getParameter("gender"))) {
				request.setAttribute("error5", "Select Gender");
				pass = false;
			} else if (DataValidator.isNull(request.getParameter("add"))) {
				request.setAttribute("error7", "Enter Your Address");
				pass = false;
			} else if (DataValidator.isNull(request.getParameter("dob"))) {
				request.setAttribute("error6", "Select Date of Birth");
				pass = false;
			} else if (DataValidator.isNull(request.getParameter("email"))) {
				request.setAttribute("error9", "Enter email");
				pass = false;
			} else if (!DataValidator.isEmail(request.getParameter("email"))) {
				request.setAttribute("error10", "Enter Email in proper Formet");
				pass = false;
			} else if (DataValidator.isNull(request.getParameter("pwd"))) {
				request.setAttribute("error11", "Enter Password");
				pass = false;
			} else if (!DataValidator.isPassword(request.getParameter("pwd"))) {
				request.setAttribute("error12", "Enter Password in formate , contains characher, one uppercase, one lowercase, one special charachter is must");
				pass = false;
			}
			if(pass==false) {
				RequestDispatcher rd=request.getRequestDispatcher("RegistrationView.jsp");
			    rd.forward(request, response);
			}else {
				try {
					model.add(bean);
					RequestDispatcher rd=request.getRequestDispatcher("RegistrationView.jsp");
					request.setAttribute("Smsg", "Successfully Inserted");
				    rd.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	          
			

			

		

	}
}

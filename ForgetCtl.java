package com.rays.servletJ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgetCtl")
public class ForgetCtl extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = 	request.getParameter("email");
		
		RegistrationModel model = new RegistrationModel();
		RegistrationBean bean = new RegistrationBean();
		PrintWriter out = response.getWriter();
		bean.setEmail(request.getParameter("login"));
		try {
			bean = model.forgetPwd(email);
			if(bean!= null) {
				request.setAttribute("pwd", bean.getPwd());
				
				RequestDispatcher rd = request.getRequestDispatcher("PasswordView.jsp");
				rd.forward(request, response);
				
				//System.out.println("bean not null......" + bean.getPwd());
				out.println("Auth Success , password is: " + bean.getPwd());
			}else {
				out.println("Auth Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}



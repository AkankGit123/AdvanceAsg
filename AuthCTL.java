package com.rays.servletJ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AuthCTL")
public class AuthCTL extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();		
		//out.println(session.getId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out1 = response.getWriter();
		//out1.println("Method:" +request.getMethod());
		//out1.println("Request URL:" +request.getRequestURI());
		//out1.println("Protocol:" +request.getProtocol());
		//out1.println("Remote Address:" +request.getRemoteAddr());
		try {
			response.setContentType("text/html");
			RegistrationModel model = new RegistrationModel();
			RegistrationBean bean = new RegistrationBean();
			bean.setEmail(request.getParameter("email"));
			bean.setPwd(request.getParameter("pwd"));
			
			RegistrationBean bean1 = new RegistrationBean();
			bean1 = model.Regis(bean.getEmail(), bean.getPwd());
			if(bean1!=null) {
				HttpSession session =request.getSession();
				String logIn = (String)request.getParameter("email");
				String pwD = (String)request.getParameter("pwd");
				session.setAttribute("user", bean1.getFname());
				//request.setAttribute("name", bean1.getFname());
				RequestDispatcher rd =  request.getRequestDispatcher("WelcomeView.jsp"); 
				rd.forward(request, response);
			}else {
				PrintWriter out = response.getWriter();			
				RequestDispatcher rd = request.getRequestDispatcher("AuthView.jsp");
				request.setAttribute("error", "Invalid Detail");			
				rd.forward(request, response);                                                        
				
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

package com.rays.servletJ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	//set cookie
	String name = (String)request.getParameter("cookieName");
	String value = (String)request.getParameter("cookieValue");
	
	Cookie c =new Cookie("Study", "JavaLanguage");
	response.addCookie(c);

}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

package com.rays.servletJ;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/.do/*")
public class FrontController implements Filter {
 
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req; 
		HttpServletResponse response = (HttpServletResponse) res; 
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email") == null) {
			request.setAttribute("sessionExp", "your session is expire,plz login again");
			RequestDispatcher rd = req.getRequestDispatcher("/AuthView.jsp");
			rd.forward(req, res);
		}
		
		else {
		chain.doFilter(req, res);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

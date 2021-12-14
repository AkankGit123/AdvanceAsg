package com.rays.servletJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentMgmtCTL")
public class StudentMgmtCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentMgmtModel md = new StudentMgmtModel();
		StudentMgmtBean bn = new StudentMgmtBean();
		bn.setId(Integer.parseInt(request.getParameter("id")));
		bn.setRollNo(request.getParameter("rollNo"));
		bn.setFirstName(request.getParameter("firstName"));
		bn.setLastName(request.getParameter("lastName"));
		bn.setSession(request.getParameter("session"));
		
		String opr = request.getParameter("operation");
		if(opr.equals("Add")) {
			//System.out.println("222");
			try {
				md.add(bn);
				//System.out.println("111111");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opr.equals("Delete")) {
			try {
				md.delete(bn);
				//System.out.println("111111");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opr.equals("Modify")) {
			try {
				md.modify(bn);
				//System.out.println("111111");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentMgmtModel md = new StudentMgmtModel();
		StudentMgmtBean bn = new StudentMgmtBean();
		String btnName= (String)request.getParameter("btn");
		try {
			if(btnName.equals("search")) {
				bn = md.getRollNo(request.getParameter("search"));
				request.setAttribute("f", bn);
				RequestDispatcher rd=request.getRequestDispatcher("StudentView.jsp");
				//System.out.println("111111");
				rd.forward(request, response);
			} if(btnName.equals("StudentList"))
			  { ArrayList<StudentMgmtBean> listB = md.StudentList();
			  request.setAttribute("G", listB);
			  RequestDispatcher  rd=request.getRequestDispatcher("StudentListWithDetail.jsp");
			  //System.out.println("111111"); rd.forward(request, response); }
			 	
			  }
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

}

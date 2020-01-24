package coreservlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MyClassesInfo;
import models.StudentInfo;
import utility.DBUtilities;
 
@WebServlet("/my-registration")
public class MyRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentInfo currentStudent = (StudentInfo) request.getSession().getAttribute("currentStudent");
		if (currentStudent == null )
		{
			request.setAttribute("loginErrMsg", "Login expired. Please login again.");
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/loginError.jsp");
		    dispatcher.forward(request, response);
		}
		
		try {
			DBUtilities utility = new DBUtilities();	 					 
			List<MyClassesInfo> classList =  utility.getMyEnrollment(currentStudent.getSsn());	
			request.setAttribute("currentStudent", currentStudent);
			request.setAttribute("myClasses", classList);			 			 
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/myRegist.jsp");
		    dispatcher.forward(request, response);
			 
		} catch (Exception e) {
			request.setAttribute("loginErrMsg", "Error occurred. Please try later.");
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/loginError.jsp");
		    dispatcher.forward(request, response);			
		}		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

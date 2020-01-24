package coreservlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("registLogin.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssn = request.getParameter("txtSSN");
		
		if (ssn == null || ssn.trim().equals(""))
		{
			request.setAttribute("loginErrMsg", "#SSN is Empty. Please provide #SSN in login page.");
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/loginError.jsp");
		    dispatcher.forward(request, response);
		}		
 		
		try {
			DBUtilities utility = new DBUtilities();
			StudentInfo student = utility.getStudentBySSN(ssn);
			
			if(student!=null){
				request.getSession().setAttribute("currentStudent", student);
				response.sendRedirect("my-registration");
			}
			else
			{ 
				request.setAttribute("loginErrMsg", "Student #SSN Not Found.");
			    RequestDispatcher dispatcher =
			    	      request.getRequestDispatcher("/WEB-INF/registrationError/loginError.jsp");
			    dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("loginErrMsg", "Error occurred. Please try later.");
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/loginError.jsp");
		    dispatcher.forward(request, response);			
		}
 
	}

}

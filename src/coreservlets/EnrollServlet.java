package coreservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CourseInfo;
import models.MyClassesInfo;
import models.StudentInfo;
import utility.DBUtilities;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CourseInfo> courses = new ArrayList<CourseInfo>();
		try{
			DBUtilities utility = new DBUtilities();
			courses =  utility.getCourseList();
		}catch(Exception ex){
			
		}
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("enroll.jsp").forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String register = request.getParameter("register");
		String drop = request.getParameter("drop");
		String courseId = request.getParameter("course");
		
		StudentInfo currentStudent = (StudentInfo) request.getSession().getAttribute("currentStudent");
		if (currentStudent == null )
		{
			request.setAttribute("loginErrMsg", "Login expired. Please login again.");
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/loginError.jsp");
		    dispatcher.forward(request, response);
		}

		try{
		DBUtilities utility = new DBUtilities();
		Boolean courseEnrolled = utility.alreadyEnrolled(currentStudent.getSsn(),courseId);
		String msg ="";
		
		if (register != null && register.equals("Register")) {
			String grade = request.getParameter("grade");	

			if(courseEnrolled){
				 msg = "The course, "+courseId+" is already enrolled for this student.<br> Please try another course. ";

			}else{
				
				Boolean success= utility.enroll(currentStudent.getSsn(),courseId,grade);
				if(success){
					response.sendRedirect("my-registration");
					return;
				}else{
					msg = "Error occured. Please try later ";
				}
			}
			
			request.setAttribute("enrollErrMsg", msg);
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/enrollRegisterError.jsp");
		    dispatcher.forward(request, response);
			
		}
		else if (drop != null && drop.equals("Drop")) {
			
			if(courseEnrolled){
				Boolean success= utility.drop(currentStudent.getSsn(),courseId);
				if(success){
					response.sendRedirect("my-registration");
					return;
				}else{
					msg = "Error occured. Please try later ";
				}
			}
			else{
				 msg = "The course, "+courseId+" does not exist in the enrollment of this student.<br> Please try another course. ";
			}
			request.setAttribute("enrollErrMsg", msg);
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/enrollDropError.jsp");
		    dispatcher.forward(request, response);			
		 }
		}catch(Exception e){
			request.setAttribute("enrollErrMsg",  "Error occured. Please try later ");
		    RequestDispatcher dispatcher =
		    	      request.getRequestDispatcher("/WEB-INF/registrationError/enrollRegisterError.jsp");
		    dispatcher.forward(request, response);			
		}
		 
	}

}

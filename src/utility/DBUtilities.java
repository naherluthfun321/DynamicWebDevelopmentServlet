package utility;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtilities {

	public StudentInfo getStudentBySSN(String ssn)
			throws SQLException, ClassNotFoundException
	{
		StudentInfo student = null;
	   
		try{	
			Connection	connection= DBConnection.createConnection();
		    // Create a statement
		    Statement statement = connection.createStatement();
		    String sql = "select ssn, firstName, mi, lastName, birthDate, street, phone, zipcode, deptId "
		    		     + " from Students where ssn ='" + ssn +"'";
		    // Execute a statement
		    ResultSet resultSet = statement.executeQuery(sql);
		    
		    if(resultSet.next()) {
		    	  //String ssn = resultSet.getString("ssn");
		    	  String firstName = resultSet.getString("firstName");
		    	  String mi = resultSet.getString("mi");
		    	  String lastName = resultSet.getString("lastName");
		    	  Date birthDate = resultSet.getDate("birthDate");
		    	  String street = resultSet.getString("street");
		    	  String phone = resultSet.getString("phone");
		    	  String zipcode = resultSet.getString("zipcode");
		    	  String deptId = resultSet.getString("deptId");
		    	  
		    	  student = new StudentInfo(ssn, firstName, mi, lastName, birthDate,street,phone,zipcode,deptId);
	 
		    	}
		}
	    catch (Exception e)
		{
		 
		}
	    
	    return student;
	}
	public List<MyClassesInfo> getMyEnrollment(String ssn)
			throws SQLException, ClassNotFoundException
	{
		List<MyClassesInfo> classList = new ArrayList<MyClassesInfo>();
	   
		try{	
		Connection	connection= DBConnection.createConnection();
	    // Create a statement
	    Statement statement = connection.createStatement();
	    String sql = "select E.courseId,C.title,E.grade"
	    		+ " from Enrollment E "
	    		+ " inner join Course C on C.courseID = E.courseId"
	    		+ " where E.ssn ='" + ssn +"'";

	    ResultSet resultSet = statement.executeQuery(sql);
	    
	    while (resultSet.next()) {	    	  
	    	  String courseId = resultSet.getString("courseId");
	    	  String title = resultSet.getString("title");
	    	  String grade = resultSet.getString("grade");	    	  
	    	  
	    	  MyClassesInfo myClass = new MyClassesInfo(courseId,title,grade);
	    	  classList.add(myClass);
 
	    	}
		}
	    catch (Exception e)
		{
		 
		}
	    
	    return classList;
	}
	public List<CourseInfo> getCourseList()	throws SQLException, ClassNotFoundException
	{
		List<CourseInfo> courseList = new ArrayList<CourseInfo>();
	   
		try{	
			Connection	connection= DBConnection.createConnection();
		    Statement statement = connection.createStatement();
		    String sql = "select distinct courseId, courseId +': ' + title title from Course order by courseId";
	
		    ResultSet resultSet = statement.executeQuery(sql);
		    
		    while (resultSet.next()) {	    	  
		    	  String courseId = resultSet.getString("courseId");
		    	  String title = resultSet.getString("title");
		    	  CourseInfo course = new CourseInfo();
		    	  course.setCourseID(courseId);
		    	  course.setTitle(title);
		    	  
		    	  courseList.add(course);	 
		    	}
		}
	    catch (Exception e)
		{
		 
		}
	    
	    return courseList;
	}	
	public Boolean alreadyEnrolled(String ssn, String courseId) {
		
		try{	
			Connection	connection= DBConnection.createConnection();
		    Statement statement = connection.createStatement();
		    String sql = "select * from Enrollment  where ssn='"+ssn+"' and courseId='"+courseId+"'";
	
		    ResultSet resultSet = statement.executeQuery(sql);		    
		    while (resultSet.next()) {	    	  
		    	return true;	 
		    }
		}
	    catch (Exception e)
		{
		 
		}
		return false;
	}
	public Boolean enroll(String ssn, String courseId, String grade) {
 		
		try {
			Connection	connection= DBConnection.createConnection();
			String sql = "INSERT INTO Enrollment(ssn, courseId, dateRegistered, grade) VALUES(?,?,getdate(),?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.setString(2, courseId);
			//statement.setDate(3, new Date(System.currentTimeMillis()));
			statement.setString(3, grade);
			statement.execute();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
public Boolean drop(String ssn, String courseId) {
 		
		try {
			Connection	connection= DBConnection.createConnection();
			String sql = "DELETE Enrollment WHERE ssn = ? AND courseId = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.setString(2, courseId);
			
			statement.execute();
			
			return true;

		} catch (SQLException e) {
			
		}
		return false;
	}	
}

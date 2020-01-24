<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enroll Course</title>
<style>
 
table {
    
    border-collapse: collapse;   
    margin-bottom: 20px;
}

td, th {    
    text-align: left;
    padding: 8px;
}
</style>
</head>
<body>
	<h2>Course Enrollment</h2>
	<div>
		<form action="enroll" method="post">
			<div>
			<table>
				<tr>
					<td>Course: </td>
					<td>
						<select name="course">
							<c:forEach items="${requestScope.courses}" var="item">
								<option label="${item.title}" value="${item.courseID}"></option>
							</c:forEach>
						</select>					
					</td>
				</tr>
				<tr>
					<td>Grade: </td>
					<td>
						<select name="grade">
							<option label="A" value="A"></option>
							<option label="B" value="B"></option>
							<option label="C" value="C"></option>
							<option label="D" value="D"></option>							
							<option label="F" value="F"></option>
						</select>						
					</td>
				</tr>								
			</table>
 
			</div>
			
		<div>	
			<input type="button" onclick="location.href='my-registration';" value=" Exit " />
			&nbsp;&nbsp;
			<input type="submit" name="drop" value="Drop">
			&nbsp;&nbsp; 
			<input type="submit" name="register" value="Register"> 
		</div>
			
		</form>	
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page language="java" import="java.util.*, java.lang.*" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Registration</title>

<style>


body {
	margin-top: .45in;
	margin-left: .5in;
	margin-bottom: .5in;
	font-size: 90%;
	font-family: arial, sans-serif;
}

  
table {
    
    border-collapse: collapse;
    width: 75%;
    margin-bottom: 20px;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(odd) {
    background-color: #dddddd;
}
th {
 	background-color: #c0c0c0;
}
 
</style>

</head>
<body>
	<h2>Course Registration</h2>
<br>
<jsp:useBean id="currentStudent" 
             type="models.StudentInfo"
             scope="request" />
             
<div>
	<span style="font-weight:bold; padding-right:5px">Name: </span>
	<span><jsp:getProperty name="currentStudent" property="fullName" /></span>
	&nbsp;
	<span style="font-weight:bold; padding:5px">Phone #: </span>
	<span><jsp:getProperty name="currentStudent" property="phone" /></span>
</div>  
<div style="font-weight:bold; padding-top:15px; padding-bottom:10px">
	MY Classes:
</div>    

	<table>
		 <tr>
		    <th>Course ID</th>
		    <th>Course Title</th>
		    <th>Grade </th>   
		  </tr>  	
		<c:forEach items="${requestScope.myClasses}" var="item">
			<tr>
				<td>${item.subjectID}</td>
				<td>${item.title}</td>
				<td>${item.grade}</td>
			</tr>
		</c:forEach>
				  
	</table>
<div>
	<input type="button" onclick="location.href='login';" value=" Exit " />
	<input type="button" onclick="location.href='enroll';" value=" Enroll " />
</div>	
</body>
</html>
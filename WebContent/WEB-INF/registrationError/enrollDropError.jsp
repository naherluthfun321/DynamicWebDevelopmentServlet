<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Drop Error</title>
</head>
<body>

<h2 style="color:red">Course Drop Error</h2>
<div style="color:red"><%=  request.getAttribute("enrollErrMsg") %></div>
<br>
<div>
	<a href="enroll">Go back to enroll page</a>
		&nbsp; &nbsp;
	<a href="my-registration">registration page</a>
</div>
</body>
</html>
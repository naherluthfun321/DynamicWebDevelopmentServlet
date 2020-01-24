<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
	table td
	{
		padding:5px;
	}
</style>
</head>
<body>
	<form action="login" method="POST">
	<div>
	<h1>&nbsp;Login</h1>
		<table>
			<tr>
				<td>SSN:</td>
				<td><input type="text" name="txtSSN"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td style="text-align:right">
				<input type="submit" value="Login">
				</td>
			</tr>			
		</table>
	</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>second jsp</title>
</head>
<body>

	<%
		out.println("<form action=\"http:localhost\" method=\"post\">");
		out.println("Enter your name: <input type=\"text\" name=\"=yourname\"></input><br>");
		out.println("Enter your age: <input type=\"text\" name=\"=yourage\"></input><br>");
		out.println("</form>");
	%>
	
</body>
</html>
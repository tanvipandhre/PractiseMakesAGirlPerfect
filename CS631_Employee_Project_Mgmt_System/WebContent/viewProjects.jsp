<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Options</title>
<style>
	.fcc-btn {
  
  
  padding: 50px 25px;
  text-decoration: none;
  align:center;
   background-color: #4CAF50;
  color: white;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
 
}
.row{
  text-align:center;
  margin-left:-20px;
  marin-right:-20px;
}

</style>
</head>
<body>
	<div class ="row">
	<br><br><br><br>
	<a class="fcc-btn" href="EmpPayRollServlet?param=create-new-project">Create a new project.</a><br>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<a class="fcc-btn" href="EmpPayRollServlet?param=statistics-on-projects">Statistics of all projects.</a>
	 </div>
</body>
</html>
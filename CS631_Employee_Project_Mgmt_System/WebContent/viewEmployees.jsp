<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payroll Types</title>
<style>
	.fcc-btn {
  background-color: #199319;
  color: white;
  padding: 50px 25px;
  text-decoration: none;
  align:center;
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
	<a class="fcc-btn" href="EmpPayRollServlet?param=view-all-full-time-emps-payroll">View Full time Employee Payroll List</a><br>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<a class="fcc-btn" href="EmpPayRollServlet?param=view-all-part-time-emps-payroll">View Part time Employee Payroll List</a>
	 </div>
</body>
</html>
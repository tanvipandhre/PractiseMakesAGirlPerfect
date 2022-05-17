<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.cs631.model.*" %>
<% ProjectView pw = (ProjectView)request.getAttribute("pview"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Team Members</title>
<style type="text/css">
input[type=text] {
  width: 300%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  color: black;
  align: center;
}
input[type=number]{
  width: 300%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  color: black;
  align: center;
}

input[type=submit] {
  width: 50%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  align:center;
}
.formDiv{
  border-radius: 5px;
  padding: 20px;
  align: center;
}
body{
background-color:#f2f2f2;

}
</style>
</head>
<body>
	<table>
		<tr>
			<td>Project ID</td>
			<td><input type="text" name="pid" readonly="readonly" value="<%=pw.getProjectId()%>"/></td>
		</tr>
		<tr>
			<td>Project Title</td>
			<td><input type="text" name="pTitle" readonly="readonly" value="<%=pw.getProjectName()%>"/></td>
		</tr>
		<tr>
			<td>Project Manager</td>
			<td><input type="text" name="pm" readonly="readonly" value="<%=pw.getProjectManagerName()%>"/></td>
		</tr>
		<%for(EmpPayRollView emp: pw.getEmpList()){ %>
		<tr>
			<td>Team Member</td>
			<td><%=emp.getEmp_name() %></td>
		</tr>
		<%} %>
	</table>
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
input[type="date"]::-webkit-calendar-picker-indicator {
    color: rgba(0, 0, 0, 0);
    opacity: 1;
    display: block;
    background: url(http://www.clipartbest.com/cliparts/9cz/67G/9cz67Gxgi.png) no-repeat;
    width: 20px;
    height: 20px;
  	border: 1px blue solid;
    border-width: thin;
}
</style>
<meta charset="ISO-8859-1">
<title>New Project</title>
</head>
<body>
	<form action="EmpPayRollServlet">
		<table>
			<tr>
				<td>Project ID</td>
				<td><input type="text" name="projectID" placeholder="Enter as PROJ_XX"/></td>
			</tr>
			<tr>
				<td>Project Title</td>
				<td><input type="text" name="projectTitle" placeholder="Enter project title"/></td>
			</tr>
			<tr>
				<td>Project Budget ($)</td>
				<td><input type="number" name="budget" placeholder="Enter amount"></td>
			</tr>
			<tr>
				<td>Project Start Date</td>
				<td><input type="date" name="startDate" placeholder="yyyy-MM-dd"><i class="fa fa-calendar"></i></td>
			</tr>
			<tr>
				<td>Project End Date</td>
				<td><input type="date" name="endDate" placeholder="yyyy-MM-dd"><i class="fa fa-calendar"></i></td>
			</tr>
			<tr>
				<td>Project Manager ID</td>
				<td><input type="text" name="projectHeadID" placeholder="Enter project manager emp id"/></td>
			</tr>
			<tr>
				<td>Project Manager Name</td>
				<td><input type="text" name="projectManger" placeholder="Enter project manager name"/></td>
			</tr>
			
			<tr>
				<td>Department ID</td>
				<td><input type="text" name="deptId" placeholder="Enter department name"/></td>
			</tr>
			
		</table>
		<input type="submit" name = "param" value="create-project">
	</form>
	
</body>
</html>
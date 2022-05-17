<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Best-P Company</title>
<style>

input[type=text] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  color: black;
  align: center;
}
.radioDiv{
  margin: 8px 0;
  border: none;
  padding: 20px;
  align:center;
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
<body >
	<h2 align="center">Welcome to Best-P Company</h2><br>
	<form action="MainServlet" method="get">
	<%Object isValidUser = request.getAttribute("isAuthUser"); %>
	
		UserID:<br><input type="text" name="userID" value="${requestScope.userID}" placeholder="Enter your userID"required><br>
	<input type = "submit" value="Submit">
		
		<%if(isValidUser!= null && isValidUser.equals(true)){ %>
		<p style = "color:green">Your authentication is successful</p>
		<p>Select the management system you want to check out.</p>
	    <div class="radioDiv">
	  
	        <input type="radio" id="employeeMgmt" name="mgmtType" value="employeeMgmt" required>
		  <label for="employeeMgmt">Employee PayRoll Management System</label>
		  <input type="radio" id="projectMgmt" name="mgmtType" value="projectMgmt">
		  <label for="projectMgmt">Project Management System</label>
		</div>
			
		<%}%>
		<%if(isValidUser!= null && isValidUser.equals(false)){ %>
			<p style = "color:red">Your authentication has failed, please try again.</p>
		<%}%>

    
	
  	<br>  
	</form>
	
</body>
</html>
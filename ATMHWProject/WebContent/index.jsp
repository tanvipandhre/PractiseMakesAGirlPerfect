<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NJIT Credit Union</title>
<style>

input[type=text] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  color: black;
  align="center";
}
.radioDiv{
  margin: 8px 0;
  border: none;
  padding: 20px;
  align="center";
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
  align="center";
}
.formDiv{
  border-radius: 5px;
  padding: 20px;
  align="center";
}
body{
background-color:#7FFFD4;

}

</style>
</head>
<body >
	<h2 align="center">NJIT Credit Union</h2><br>
	<form action="MainServlet" method="get">
	<%Object isValidUser = request.getAttribute("isAuthUser"); %>
	
		UserID:<br><input type="text" name="userID" value="${requestScope.userID}" placeholder="Enter bank userID"required><br>
	<input type = "submit" value="Submit">
		
		<%if(isValidUser!= null && isValidUser.equals(true)){ %>
		<p style = "color:green">Your authentication is successful</p>
		<p>Select the transaction you want to perform.</p>
	    <div class="radioDiv">
	  
	        <input type="radio" id="withdraw" name="transaction" value="withdraw" required>
		  <label for="withdraw">Withdraw</label>
		  <input type="radio" id="deposit" name="transaction" value="deposit">
		  <label for="deposit">Deposit</label>
		</div>
			<input type ="text" name="amount"  value="${requestScope.amount}" placeholder="enter amount" required><br>
			<p style = "color:green">Your balance is <%=request.getAttribute("balance") %>
			<%Object w = request.getAttribute("isWithdrawNotPossible"); %>
			<%if(w!=null && w.equals(true)){ %>
				<p style = "color:red">There is insufficient funds, please try a smaller amount.</p>
			<%}%>
		<%}%>
		<%if(isValidUser!= null && isValidUser.equals(false)){ %>
			<p style = "color:red">Your authentication has failed, please try again.</p>
		<%}%>

    
	
  	<br>  
	</form>
	
</body>
</html>
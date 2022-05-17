
   <%@page import="java.util.*" %>
   <%@page import="com.cs631.model.*" %>
 <% List<com.cs631.model.EmpPayRollView> listOfemp = (List<com.cs631.model.EmpPayRollView>)request.getAttribute("listOfEmployees") ;%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Payroll Page</title>
<style>
        #tbl {
          font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }
 
        #tbl td, #tbl th {
          border: 1px solid #ddd;
          padding: 8px;
        }
 
        #tbl tr:nth-child(even){background-color: #f2f2f2;}
 
        #tbl tr:hover {background-color: #ddd;}
 
        #tbl th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #294c67;;
            color: white;
          }
      </style>
   	
	<meta charset="utf-8" />
	<title>Export HTML table data to excel using JavaScript</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
	 <script>

	 function exportTableToExcel(tableID, filename = ''){
		    var downloadLink;
		    var dataType = 'application/vnd.ms-excel';
		    var tableSelect = document.getElementById(tableID);
		    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
		    
		    // Specify file name
		    filename = filename?filename+'.xls':'excel_data.xls';
		    
		    // Create download link element
		    downloadLink = document.createElement("a");
		    
		    document.body.appendChild(downloadLink);
		    
		    if(navigator.msSaveOrOpenBlob){
		        var blob = new Blob(['\ufeff', tableHTML], {
		            type: dataType
		        });
		        navigator.msSaveOrOpenBlob( blob, filename);
		    }else{
		        // Create a link to the file
		        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
		    
		        // Setting the file name
		        downloadLink.download = filename;
		        
		        //triggering the function
		        downloadLink.click();
		    }
		}
	    
    </script>
	
   
    
</head>
<body>
	
		<table id="employee_data" class="table table-striped table-bordered">
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Department Name</th>
				<th>Division Name</th>
				<th>Job Title</th>
				<th>Is Part Time?</th>
				<th>Salary per hour</th>
				<th>No. of working days</th>
				<th>No. of working hours</th>
				<th>Total salary</th>
			</tr>
			<%for(com.cs631.model.EmpPayRollView emp : listOfemp){ %>
			<tr>
				<td><%=emp.getEmp_id() %></td>
				<td><%=emp.getEmp_name() %></td>
				<td><%=emp.getDept_name() %></td>
				<td><%=emp.getDiv_name() %></td>
				<td><%=emp.getTitle() %></td>
				<td><%=emp.getIs_part_time() %></td>
				<td><%=emp.getSalary_per_hour() %></td>
				<td><%=emp.getNo_of_working_days() %></td>
				<td><%=emp.getNo_of_working_hours() %></td>
				<td><%=emp.getTotal_salary() %></td>
				
			</tr>
			<%} %>
		</table>
	
    	<button onClick="exportTableToExcel('employee_data','members-data')">Export table to excel</button>
    
	</body>
</html>
package com.cs631.employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cs631.model.ProjectView;

public class EmployeePayRollImpl {
	
	public List<com.cs631.model.EmpPayRollView> populateFullTimeEmpFromDeptData(){
		
		
		List<com.cs631.model.EmpPayRollView> empPayRollViewList = new ArrayList<com.cs631.model.EmpPayRollView>();
		try {
			
			com.cs631.common.DbConnection dbConnection=new com.cs631.common.DbConnection();
			Connection con=dbConnection.dbConnect();
			if(con!=null) {
				System.out.println("Connection established successfully.- impl");
			}else {
				System.out.println("Connection not established yet.-impl");
			}
			Statement stmt=con.createStatement();
			//String selectAllEmpQuery="select distinct e.Emp_ID, dt.Dept_name from Employee e, department dt, division dd, employed ed, part_of_div pd where e.is_part_time=0 and e.Dept_ID=dt.Dept_ID;";
			String selectAllFullTimeEmpQuery  = "select distinct e.Emp_ID, e.Emp_name,dt.Dept_name , dd.Div_name, ed.Title, e.is_part_time,ed.salary_per_hour, e.no_of_working_days , e.no_of_working_hours from Employee e, department dt, division dd, employed ed, part_of_div pd  where e.is_part_time=0 and e.Dept_ID=dt.Dept_ID and e.Div_Id = dd.Div_Id and e.Emp_ID = ed.Emp_ID order by ed.Title";
			System.out.println("Query begin");
			ResultSet rs=stmt.executeQuery(selectAllFullTimeEmpQuery);
			while(rs.next()) {
				com.cs631.model.EmpPayRollView emp = new com.cs631.model.EmpPayRollView();
				emp.setEmp_id(rs.getString("Emp_ID"));
				emp.setEmp_name(rs.getString("Emp_name"));
				emp.setDept_name(rs.getString("Dept_name"));
				emp.setDiv_name(rs.getString("Div_name"));
				emp.setTitle(rs.getString("Title"));
				emp.setNo_of_working_days(rs.getInt("no_of_working_days"));
				emp.setNo_of_working_hours(rs.getInt("no_of_working_hours"));
				emp.setIs_part_time(rs.getInt("is_part_time"));
				emp.setSalary_per_hour(rs.getDouble("salary_per_hour"));
				int noOfWorkHrs = rs.getInt("no_of_working_hours");
				int noOfWorkDays = rs.getInt("no_of_working_days");
				double salaryPerHour = rs.getDouble("salary_per_hour");
				double salary = noOfWorkDays * noOfWorkHrs * salaryPerHour;
				double taxes = salary * 0.18;
				salary = salary - taxes;
				emp.setTotal_salary(salary);
				
				
				empPayRollViewList.add(emp);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return empPayRollViewList;
		
	}
public List<com.cs631.model.EmpPayRollView> populatePartTimeEmpFromDeptData(){
		
		
		List<com.cs631.model.EmpPayRollView> empPayRollViewList = new ArrayList<com.cs631.model.EmpPayRollView>();
		try {
			
			com.cs631.common.DbConnection dbConnection=new com.cs631.common.DbConnection();
			Connection con=dbConnection.dbConnect();
			if(con!=null) {
				System.out.println("Connection established successfully.- impl");
			}else {
				System.out.println("Connection not established yet.-impl");
			}
			Statement stmt=con.createStatement();
			//String selectAllEmpQuery="select distinct e.Emp_ID, dt.Dept_name from Employee e, department dt, division dd, employed ed, part_of_div pd where e.is_part_time=0 and e.Dept_ID=dt.Dept_ID;";
			String selectAllPartTimeEmpQuery  = "select distinct e.Emp_ID, e.Emp_name,dt.Dept_name , dd.Div_name, ed.Title, e.is_part_time,ed.salary_per_hour, e.no_of_working_days , e.no_of_working_hours from Employee e, department dt, division dd, employed ed, part_of_div pd  where e.is_part_time=1 and e.Dept_ID=dt.Dept_ID and e.Div_Id = dd.Div_Id and e.Emp_ID = ed.Emp_ID order by ed.Title";
			System.out.println("Query begin");
			ResultSet rs=stmt.executeQuery(selectAllPartTimeEmpQuery);
			while(rs.next()) {
				com.cs631.model.EmpPayRollView emp = new com.cs631.model.EmpPayRollView();
				emp.setEmp_id(rs.getString("Emp_ID"));
				emp.setEmp_name(rs.getString("Emp_name"));
				emp.setDept_name(rs.getString("Dept_name"));
				emp.setDiv_name(rs.getString("Div_name"));
				emp.setTitle(rs.getString("Title"));
				emp.setNo_of_working_days(rs.getInt("no_of_working_days"));
				emp.setNo_of_working_hours(rs.getInt("no_of_working_hours"));
				emp.setIs_part_time(rs.getInt("is_part_time"));
				emp.setSalary_per_hour(rs.getDouble("salary_per_hour"));
				int noOfWorkHrs = rs.getInt("no_of_working_hours");
				int noOfWorkDays = rs.getInt("no_of_working_days");
				double salaryPerHour = rs.getDouble("salary_per_hour");
				double salary = noOfWorkDays * noOfWorkHrs * salaryPerHour;
				double taxes = salary * 0.18;
				salary = salary - taxes;
				emp.setTotal_salary(salary);
				
				
				empPayRollViewList.add(emp);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return empPayRollViewList;
		
	}
	public String storeProjectDetails(com.cs631.model.ProjectView proj) {
		
		try {
				com.cs631.common.DbConnection dbConnection=new com.cs631.common.DbConnection();
				Connection con=dbConnection.dbConnect();
				if(con!=null) {
					System.out.println("Connection established successfully.- impl");
				}else {
					System.out.println("Connection not established yet.-impl");
				}
				Statement stmt=con.createStatement();
				String projectId = proj.getProjectId();
				String projectName = proj.getProjectName();
				double budget = proj.getBudget();
				String startDate = proj.getStartDate();
				System.out.println("start Date "+startDate);
				String endDate = proj.getEndDate();
				String projectHeadId = proj.getProjectHeadId();
				String projManager = proj.getProjectManagerName();
				String insertprojQuery = "insert into Project(Project_ID, Project_Title, Project_Budget, Project_Start_Date, Project_End_Date) values('"+projectId+"', '"+projectName+"','"+budget+"', str_to_date('"+startDate+"','%Y-%m-%d'),str_to_date('"+endDate+"','%Y-%m-%d' ))";
				System.out.println(insertprojQuery);
				String insertManagerQuery = "insert into Project_Manage(Project_ID, Project_head_id, Manager_name) values ('"+projectId+"','"+projectHeadId+"', '"+projManager+"')"; 
				System.out.println(insertManagerQuery);
				int noOfAffectedRow = stmt.executeUpdate(insertprojQuery);
				int noOfManagerAdded = stmt.executeUpdate(insertManagerQuery);
				if(noOfAffectedRow>0 && noOfManagerAdded>0){
					return "row successfully inserted";
				}else {
					return "no rows inserted";
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	public ProjectView viewProjectTeamDeatail(ProjectView proj) {
		
		String deptId= proj.getDeptId();
		ArrayList<com.cs631.model.EmpPayRollView> empPayRollViewList = new ArrayList<com.cs631.model.EmpPayRollView>();
		try {
			
			com.cs631.common.DbConnection dbConnection=new com.cs631.common.DbConnection();
			Connection con=dbConnection.dbConnect();
			if(con!=null) {
				System.out.println("Connection established successfully.- impl");
			}else {
				System.out.println("Connection not established yet.-impl");
			}
			Statement stmt=con.createStatement();
			//String selectAllEmpQuery="select distinct e.Emp_ID, dt.Dept_name from Employee e, department dt, division dd, employed ed, part_of_div pd where e.is_part_time=0 and e.Dept_ID=dt.Dept_ID;";
			String selectAllFullTimeEmpQuery  = "select distinct  e.Emp_name from Employee e, department dt  where  e.Dept_ID=dt.Dept_ID and dt.Dept_ID = '"+deptId+"' ";
			System.out.println("Query begin");
			System.out.println(selectAllFullTimeEmpQuery);
			ResultSet rs=stmt.executeQuery(selectAllFullTimeEmpQuery);
			while(rs.next()) {
				com.cs631.model.EmpPayRollView emp = new com.cs631.model.EmpPayRollView();
				
				emp.setEmp_name(rs.getString("Emp_name"));
				empPayRollViewList.add(emp);
				
			}
			proj.setEmpList(empPayRollViewList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return proj;
		
		
	}

}

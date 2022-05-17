package com.cs631.model;
import java.util.Date;

/*Emp_ID numeric(10) not null,
    Emp_Name varchar(20),
    Date_of_joining date,
    is_div_affiliated numeric(1),
    is_part_time numeric(1),
    no_of_working_hours numeric(2),
    no_of_working_days numeric(10),
    Div_Id varchar(10),
    Dept_Id varchar(10),
    Project_ID varchar(10),
    Building_code varchar(10),
    Room_ID varchar(10),
    
    
    Dept_ID varchar(10) not null,
    Dept_name varchar(20),
    Dept_Budget numeric(13,2),
    
    Div_Id varchar(10) not null,
    Div_name  varchar(20),
    
    Emp_ID numeric(10) not null,  
    Start_date date, 
    End_date date, 
    Title varchar(20), 
    Salary numeric(13,2), 
    Dept_ID varchar(10) , 
    Dept_name varchar(20),
    
    
    */

/**
 * @author - Tanvi Pandhre
 */
public class EmpPayRollView {
	//emp
	private String emp_id; 
	private String emp_name; 
	private Date date_of_joining;
	private int is_div_affiliated;
	private int is_part_time;
	private int no_of_working_hours;
	private int no_of_working_days;
	private String div_id; 
	private String dept_id; 
	private String project_id;
	private String building_code;
	private String roomid;
	//dept
	private String dept_name;
	private double dept_budget;
	//div
	private String div_name;
	//employed //part_of_div
	private String title; //6
	private double salary_per_hour;
	private double total_salary;
	public double getTotal_salary() {
		return total_salary;
	}
	public void setTotal_salary(double total_salary) {
		this.total_salary = total_salary;
	}
	public double getSalary_per_hour() {
		return salary_per_hour;
	}
	public void setSalary_per_hour(double salary_per_hour) {
		this.salary_per_hour = salary_per_hour;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Date getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	public int getIs_div_affiliated() {
		return is_div_affiliated;
	}
	public void setIs_div_affiliated(int is_div_affiliated) {
		this.is_div_affiliated = is_div_affiliated;
	}
	public int getIs_part_time() {
		return is_part_time;
	}
	public void setIs_part_time(int is_part_time) {
		this.is_part_time = is_part_time;
	}
	public int getNo_of_working_hours() {
		return no_of_working_hours;
	}
	public void setNo_of_working_hours(int no_of_working_hours) {
		this.no_of_working_hours = no_of_working_hours;
	}
	public int getNo_of_working_days() {
		return no_of_working_days;
	}
	public void setNo_of_working_days(int no_of_working_days) {
		this.no_of_working_days = no_of_working_days;
	}
	public String getDiv_id() {
		return div_id;
	}
	public void setDiv_id(String div_id) {
		this.div_id = div_id;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getBuilding_code() {
		return building_code;
	}
	public void setBuilding_code(String building_code) {
		this.building_code = building_code;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public double getDept_budget() {
		return dept_budget;
	}
	public void setDept_budget(double dept_budget) {
		this.dept_budget = dept_budget;
	}
	public String getDiv_name() {
		return div_name;
	}
	public void setDiv_name(String div_name) {
		this.div_name = div_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
		
	
}

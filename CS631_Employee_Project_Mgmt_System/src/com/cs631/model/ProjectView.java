package com.cs631.model;

import java.util.ArrayList;

//import java.util.Date;

public class ProjectView {
	private String projectId;
	private String projectName;
	private double budget;
	private String startDate;
	private String endDate;
	private String projectHeadId;
	private String projectManagerName;
	private ArrayList<EmpPayRollView> empList;
	private String deptId;
	
	
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public ArrayList<EmpPayRollView> getEmpList() {
		return empList;
	}
	public void setEmpList(ArrayList<EmpPayRollView> empList) {
		this.empList = empList;
	}
	public String getProjectHeadId() {
		return projectHeadId;
	}
	public void setProjectHeadId(String projectHeadId) {
		this.projectHeadId = projectHeadId;
	}
	public String getProjectManagerName() {
		return projectManagerName;
	}
	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}

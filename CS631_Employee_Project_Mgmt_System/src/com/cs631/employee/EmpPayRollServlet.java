package com.cs631.employee;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs631.model.ProjectView;

/**
 * Servlet implementation class EmpPayRollServlet
 */
@WebServlet("/EmpPayRollServlet")
public class EmpPayRollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpPayRollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = request.getParameter("param");
		EmployeePayRollImpl employeePayRollImpl = new EmployeePayRollImpl();
		if("view-all-full-time-emps-payroll".equalsIgnoreCase(value)) {
			
			List<com.cs631.model.EmpPayRollView> empPayRollViewList = employeePayRollImpl.populateFullTimeEmpFromDeptData();
			request.setAttribute("listOfEmployees", empPayRollViewList);
			ServletContext ctxt=getServletContext();
			RequestDispatcher rd=ctxt.getRequestDispatcher("/viewEmpPayRollDetails.jsp");
			rd.forward(request,response);
			
		}else if("view-all-part-time-emps-payroll".equalsIgnoreCase(value)) {
			List<com.cs631.model.EmpPayRollView> empPayRollViewList = employeePayRollImpl.populatePartTimeEmpFromDeptData();
			request.setAttribute("listOfEmployees", empPayRollViewList);
			ServletContext ctxt=getServletContext();
			RequestDispatcher rd=ctxt.getRequestDispatcher("/viewEmpPayRollDetails.jsp");
			rd.forward(request,response);
		}else if("create-new-project".equalsIgnoreCase(value)) {
			ServletContext ctxt=getServletContext();
			RequestDispatcher rd=ctxt.getRequestDispatcher("/createProject.jsp");
			rd.forward(request,response);
		}else if("create-project".equalsIgnoreCase(value)) {
			ProjectView proj = new ProjectView();
			proj.setProjectId(request.getParameter("projectID"));
			proj.setProjectName(request.getParameter("projectTitle"));
			proj.setBudget(Double.parseDouble(request.getParameter("budget")));
			proj.setStartDate(request.getParameter("startDate"));
			proj.setEndDate(request.getParameter("endDate"));
			proj.setProjectHeadId(request.getParameter("projectHeadID"));
			proj.setProjectManagerName(request.getParameter("projectManger"));
			proj.setDeptId(request.getParameter("deptId"));
			String rowsAffected = employeePayRollImpl.storeProjectDetails(proj);
			System.out.println(rowsAffected);
			String pid = proj.getProjectId();
			request.setAttribute("projId", pid);
			ProjectView pvw = employeePayRollImpl.viewProjectTeamDeatail(proj);
			request.setAttribute("pview", pvw);
			ServletContext ctxt=getServletContext();
			RequestDispatcher rd=ctxt.getRequestDispatcher("/viewProjectDetails.jsp");
			rd.forward(request,response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

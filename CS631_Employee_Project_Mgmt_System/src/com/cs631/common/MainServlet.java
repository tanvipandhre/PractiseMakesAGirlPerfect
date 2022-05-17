package com.cs631.common;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userID = request.getParameter("userID");
		String mgmtType = request.getParameter("mgmtType");
		
		boolean isAuthUser = false;
		
		System.out.println(userID);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs631DB?useUnicode=true&characterEncoding=utf8","root", "rootroot");
			if(conn!=null) {
				System.out.println("connection yes");
			}else {
				System.out.println("connection no");
			}
			Statement stmt = conn.createStatement();
			String selectQuery ="select * from users where userId='"+userID+"'";
			System.out.println(selectQuery);
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			if(rs.next()) {
				isAuthUser = true;
								
			}
			request.setAttribute("isAuthUser", isAuthUser);
			if(isAuthUser) {
				request.setAttribute("userID", userID);
				if("employeeMgmt".equals(mgmtType)) {
					request.getRequestDispatcher("/viewEmployees.jsp").forward(request, response);
				}else if("projectMgmt".equals(mgmtType)) {
					request.getRequestDispatcher("/viewProjects.jsp").forward(request, response);
				}
			}
			
		
			
	        request.getRequestDispatcher("/index.jsp").forward(request, response);	
        
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return message;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

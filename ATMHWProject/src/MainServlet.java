

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
		String transaction = request.getParameter("transaction");
		String amount = request.getParameter("amount");
		boolean isAuthUser = false;
		double currentBalance = 0.0;
		boolean isWithdrawNotPossible = false;
		System.out.println(userID);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM?useUnicode=true&characterEncoding=utf8","root", "rootroot");
			if(conn!=null) {
				System.out.println("connection yes");
			}else {
				System.out.println("connection no");
			}
			Statement stmt = conn.createStatement();
			String selectQuery ="select * from accountInfo where userID='"+userID+"'";
			System.out.println(selectQuery);
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			if(rs.next()) {
				isAuthUser = true;
				currentBalance =  Double.parseDouble(rs.getString("balance"));
				
			}
			System.out.println(request.getParameter("amount"));
			
			if(request.getParameter("amount")==null) {
				
				
			}else {
				if(isAuthUser) {
					
					if(request.getParameter("amount") !=null || !request.getParameter("amount").isEmpty()) {
						double amounttransaction = Double.parseDouble(request.getParameter("amount"));
						if("deposit".equals(transaction)) {
							currentBalance+=amounttransaction;
						}else if("withdraw".equals(transaction) ) {
							if(amounttransaction<currentBalance) {
								
								currentBalance-=amounttransaction;
							}else {
								isWithdrawNotPossible =true;
							}
							
						}
						String updateQuery = "update accountInfo set balance = '"+currentBalance+"' where userID ='"+userID+"' ";
						System.out.println(updateQuery);
						stmt.executeUpdate(updateQuery);
						
					}
					
				}
		       
			}
				request.setAttribute("isWithdrawNotPossible", isWithdrawNotPossible);
				if(isAuthUser) {
					request.setAttribute("userID", userID);
				}
				request.setAttribute("amount", amount);
				request.setAttribute("balance", currentBalance);
				request.setAttribute("isAuthUser", isAuthUser);
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



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{
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
		Cookie acookie = new Cookie("Visitor", "yes");
        acookie.setMaxAge(365*24*60*60);
        response.addCookie(acookie); //adds cookie to the client computer
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
        "<head><title>Processing Cookies</title></head>\n" +
        "<body bgcolor=\"#fdf5e6\">\n" +
        "<h1 align = \"center\"> Thanks I will remember you </h1>\n" +
        "</body></html>"
        		);
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

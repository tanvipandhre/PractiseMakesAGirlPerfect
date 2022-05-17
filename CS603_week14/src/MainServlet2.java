

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet2
 */
@WebServlet("/MainServlet2")
public class MainServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "Thank you for visiting us again";
		Cookie[] cookies = request.getCookies(); //obtains all cookies from the client
		if(cookies != null && cookies.length > 0) {
			for(int i = 0;i<cookies.length; i++) {
				Cookie c = cookies[i];
				if((c.getName().equals("Visitor")) && c.getValue().equals("yes")) {
					break;
				}else {
					message = "I am sorry, you have not visited us before.";
				}
			}
			
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>\n" +
		"<head><title>Processing cookies</title></head>"+
		"<body bgcolor=\"#fdf5e6\">"+
		"<h1 cligh = \"center\" >" +message +"</h1>"+
		"<body></html>"
				);
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

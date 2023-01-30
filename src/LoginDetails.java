

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "logindetails", urlPatterns = { "/logindetails" })
public class LoginDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");

		
		if(password.equals("123")){
			
			out.print("<br/> ");
			out.print("Username : " + uname);
			out.print("<br/> ");
			out.print("Password : "+ password);
			
			Cookie ck = new Cookie("key", uname);
			response.addCookie(ck);
			response.sendRedirect("profile");
			
		}
		else{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
			out.print("<p style = 'color:red; padding-top:4px;'>Invalid Password!</p>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}

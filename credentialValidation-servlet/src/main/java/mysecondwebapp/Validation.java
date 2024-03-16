package mysecondwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/validate")
public class Validation extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("p");
		
		if(email.equals("jspiders@gmail.com") && password.equals("1234"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("formValidate.html");
			rd.forward(req,res);
		}
		else {
			PrintWriter pw=res.getWriter();
			pw.println("<h1>Invalid credential</h1>");
			
			RequestDispatcher rd= req.getRequestDispatcher("login.html");
			rd.include(req,res);
			
			
		}
		
	}

}

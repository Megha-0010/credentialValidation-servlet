package httpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveuserinfo")
public class SaveUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_001", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into user(id,name,email,password)value(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setString(3,email);
			ps.setString(4, password);
			
			ps.execute();
			
			PrintWriter pw=resp.getWriter();
			pw.print("<h1 style=color:green> User Data Saved Successfully</h1>");
			
			FetchUser fu=new FetchUser();
			fu.doGet(req, resp);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}

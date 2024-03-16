package mysecondwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/validates")
public class ValidateThroughDB extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("p");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_001", "root", "root");
//			Statement st = con.createStatement();
//			String sql = "select * from user;";
//			ResultSet rs = st.executeQuery(sql);

			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {

				String email1 = rs.getString("email");
				String password1 = rs.getString("password");

				if (email1.equals(email) && password1.equals(password)) {
					RequestDispatcher rd = req.getRequestDispatcher("formValidate.html");
					rd.forward(req, res);
				}
			}
				else {
					PrintWriter pw = res.getWriter();
					pw.println("<h1>Invalid credential</h1>");

					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, res);

				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

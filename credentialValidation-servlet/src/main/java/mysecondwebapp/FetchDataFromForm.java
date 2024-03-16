package mysecondwebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fetchdata")
public class FetchDataFromForm extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_001", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into student(id,name,age)value(?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setInt(3, Integer.parseInt(age));

			ps.execute();
			System.out.println("data saved successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		 catch (SQLException e) {
				e.printStackTrace();

	}
	}

}

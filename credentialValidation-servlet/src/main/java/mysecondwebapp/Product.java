package mysecondwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/saveproduct")
public class Product extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String brand = req.getParameter("brand");
		String category = req.getParameter("category");
		String cost = req.getParameter("cost");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_001", "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into product(id,brand,category,cost)value(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, brand);
			ps.setString(3, category);
			ps.setDouble(4, Double.parseDouble(cost));

			ps.execute();

			PrintWriter pw = res.getWriter();
			pw.print("<h1> Product saved successfully </h1>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.jsp.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginvalidatedb")
public class LoginValidateThroughDB extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_001", "root", "root");
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String email1 = rs.getString("email");
				String password1 = rs.getString("password");

				if (email1.equals(email) && password1.equals(password)) {
					Cookie c1 = new Cookie("email", email);
					c1.setMaxAge(500);
					
					Cookie c2 = new Cookie("password", password);
					c2.setMaxAge(500);
					
					resp.addCookie(c1);
					resp.addCookie(c2);

					RequestDispatcher rd = req.getRequestDispatcher("welcomeBack.html");
					rd.forward(req, resp);
				}
			} else {
				PrintWriter pw = resp.getWriter();
				pw.println("<h1>Invalid credential</h1>");

				RequestDispatcher rd = req.getRequestDispatcher("Login_Cookie.html");
				rd.include(req, resp);
			}
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);

	}

}

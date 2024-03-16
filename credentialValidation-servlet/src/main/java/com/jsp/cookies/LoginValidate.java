package com.jsp.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginvalidate")
public class LoginValidate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email.equals("jspider@gmail.com") && (password.equals("1234"))) {
			
			Cookie c1 = new Cookie("email", email);
			c1.setMaxAge(500);
			
			Cookie c2 = new Cookie("password", password);
			c2.setMaxAge(500);
			
			resp.addCookie(c1);
			resp.addCookie(c2);

			RequestDispatcher rd = req.getRequestDispatcher("welcomeBack.html");
			rd.forward(req, resp);
		} else {
			PrintWriter pw = resp.getWriter();
			pw.println("<h1>Invalid credential</h1>");

			RequestDispatcher rd = req.getRequestDispatcher("Login_Cookie.html");
			rd.include(req, resp);
		}
	}
}

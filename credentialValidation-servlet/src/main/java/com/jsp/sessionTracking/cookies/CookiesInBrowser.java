package com.jsp.sessionTracking.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/savecookie")
public class CookiesInBrowser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("id", "1");
		cookie1.setMaxAge(120);
		Cookie cookie2 = new Cookie("email", "sharma@gmail.com");
		cookie2.setMaxAge(120);
		Cookie cookie3 = new Cookie("password", "111");
		cookie3.setMaxAge(120);

		resp.addCookie(cookie1); // addcookie() id used to save cookies in the browser
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);

		PrintWriter pw = resp.getWriter();
		pw.println("<h1> cookies saved succesfully</h1>");

	}

}

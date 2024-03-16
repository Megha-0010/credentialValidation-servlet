package com.jsp.cookies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/check")
public class CheckCookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookie=req.getCookies();
				if(cookie==null) {
					RequestDispatcher rd = req.getRequestDispatcher("Login_Cookie.html");
					rd.forward(req, resp);
				}
				else {
					RequestDispatcher rd = req.getRequestDispatcher("welcome_Back.html");
					rd.forward(req, resp);
				}
	}

}

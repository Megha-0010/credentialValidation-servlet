package com.jsp.httpSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/saveinsession")
public class SaveDataInSession extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		HttpSession session1 = req.getSession();
		
		
		session.setAttribute("id", 1);
		session.setAttribute("name", "megha");
		session.setAttribute("active", true);
		

		//System.out.println(session);
//		System.out.println(session1.getAttribute("id"));//1
//		System.out.println(session1.getAttribute("name"));//megha
//		System.out.println(session1.getAttribute("active"));//true
//		System.out.println(session1.getAttribute("dateofbirth")); //null
		
		session1.removeAttribute("id");
		session1.invalidate();
		System.out.println(session1.getAttribute("name")); //invalidate session exception
	}

}

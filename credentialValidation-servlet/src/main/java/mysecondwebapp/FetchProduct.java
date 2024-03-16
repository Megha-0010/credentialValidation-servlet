package mysecondwebapp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product")
public class FetchProduct extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String productCategry = req.getParameter("pc");
		String product = req.getParameter("p");

		System.out.println("ProductId : "+id);
		System.out.println("productCategry : "+productCategry);
		System.out.println("product : "+product);
	}

}
